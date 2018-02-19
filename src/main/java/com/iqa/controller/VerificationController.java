package com.iqa.controller;


import com.iqa.domain.countries.exception.CountryNotFoundException;
import com.iqa.domain.countries.model.Countries;
import com.iqa.domain.countries.service.CountriesService;
import com.iqa.domain.derived.country.model.Country;
import com.iqa.institutes.exception.InstitutesNotFoundException;
import com.iqa.institutes.model.InstitutesEntity;
import com.iqa.institutes.service.InstitutesService;
import com.iqa.profile.individual.model.LoginRequest;
import com.iqa.profiles.exception.ProfilesNotFoundException;
import com.iqa.profiles.model.ProfileEntity;
import com.iqa.profiles.service.ProfilesService;
import com.iqa.verificationrequest.exception.VerificationRequestNotFoundException;
import com.iqa.verificationrequest.model.VerificationRequestEntity;
import com.iqa.verificationrequest.service.VerificationRequestService;
import com.iqa.verifiedcandidates.exception.VerifiedCandidatesNotFoundException;
import com.iqa.verifiedcandidates.model.CandidatesVerifiedEntity;
import com.iqa.verifiedcandidates.service.VerifiedCandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


@ControllerAdvice
@Controller
public class VerificationController {


    @Autowired
    ProfilesService profilesService;

    @Autowired
    CountriesService countriesService;

    @Autowired
    VerificationRequestService verificationRequestService;

    @Autowired
    InstitutesService institutesService;

    @Autowired
    VerifiedCandidatesService verifiedCandidatesService;


    public static String byteToString(byte[] _bytes) {
        String file_string = "";

        for (int i = 0; i < _bytes.length; i++) {
            file_string += (char) _bytes[i];
        }

        return file_string;
    }

//    @RequestMapping({"/"})
//    public String getIndex() {
//        return "index";
//    }


    @RequestMapping({"/verification_login","/profile"})
    public String loginVerification(HttpServletRequest request, LoginRequest loginRequest, Model model, HttpSession session,
                                    @RequestParam(value = "username", required = false) String username, @RequestParam(value = "searchText", required = false) String searchText
            , @RequestParam(value = "password", required = false) String password, final RedirectAttributes redirectAttributes) {
        ProfileEntity profileEntity;
        String url = request.getRequestURI();
        int index = url.lastIndexOf("/");
        if (index != -1) {
            if (url.contains("profile")) {
                model.addAttribute("profile", session.getAttribute("profile"));
                model.addAttribute("alertMessage", null);
                ProfileEntity profileEntity1= (ProfileEntity) session.getAttribute("profile");
                try {
                    model.addAttribute("countryName", countriesService.findByCountryId(profileEntity1.getCountryId()).getName());
                } catch (CountryNotFoundException e) {
                    e.printStackTrace();
                }
                return "profile";
            }
            else if (url.contains("verification_login")) {
                try {
                    profileEntity = profilesService.findProfileByUsernameAndPassword(username, password);
                    model.addAttribute("countryName", countriesService.findByCountryId(profileEntity.getCountryId()).getName());
                    model.addAttribute("profile", profileEntity);
                    session.setAttribute("profile", profileEntity);
                    model.addAttribute("alertMessage", null);

                    return "profile";
                } catch (ProfilesNotFoundException | NoSuchAlgorithmException e) {
                    redirectAttributes.addFlashAttribute("alertMessage", "Wrong Login Credentials Please Provide Correct Credentials");
                    model.addAttribute("alertMessage", "Wrong Login Credentials Please Provide Correct Credentials");
                    return "redirect:login";
                } catch (CountryNotFoundException e) {
                    e.printStackTrace();
                }
            }


        }

        return "profile";
    }

    @RequestMapping(value = {"/verification","/checkout_payment"}, method = RequestMethod.GET)
    public String verification(HttpServletRequest request, Model model, HttpSession session, @RequestParam(value = "countryId", required = false) String countryId) {
        String url = request.getRequestURI();
        int index = url.lastIndexOf("/");

        if (index != -1) {
            if (url.contains("verification")) {
                try {

                    List<Country> countries = countriesService.getAllCountries();
                    model.addAttribute("countries", countries);
                    session.setAttribute("countries", countries);
                    model.addAttribute("institutes", null);
                    model.addAttribute("profile", session.getAttribute("profile"));
                    model.addAttribute("searchButton", true);
                    model.addAttribute("selectedCountryName", null);
                    model.addAttribute("errorMessage", null);

                    return "verification";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                model.addAttribute("profile", session.getAttribute("profile"));
                return "checkout_payment";
            }

        }
        return "profile";
    }

    @RequestMapping(value = {"/getInstitutions"}, method = RequestMethod.POST)
    public String getInstuteByCountryId(HttpServletRequest request, Model model, HttpSession session, @RequestParam(value = "countryId", required = false) String countryId
            , @RequestParam(value = "instituteId", required = false) String instituteId, @RequestParam(value = "candidateId", required = false) String candidateId
            , @RequestParam(value = "action", required = false) String action) {


        String url = request.getRequestURI();
        int index = url.lastIndexOf("/");
        model.addAttribute("errorMessage", null);

        if (index != -1) {
            model.addAttribute("profile", session.getAttribute("profile"));
            model.addAttribute("countries", session.getAttribute("countries"));
            model.addAttribute("searchButton", false);
            if (url.contains("getInstitutions") && candidateId == null && instituteId == null) {
                String[] spiltRequest = countryId.split(",");
                try {
                    List<InstitutesEntity> institutesEntities = institutesService.getInstitutesByCountry(Integer.parseInt(spiltRequest[0]));
                    model.addAttribute("institutes", institutesEntities);
                } catch (Exception e) {
                    model.addAttribute("institutes", null);
                    model.addAttribute("searchButton", true);
                    model.addAttribute("errorMessage", "No Institute Available for Selected Country");
                }


                model.addAttribute("selectedCountryName", spiltRequest[1]);
                session.setAttribute("selectedCountryName", spiltRequest[1]);
                return "verification";
            } else if (url.contains("getInstitutions") && candidateId != null && instituteId != null) {
                verificationRequest(instituteId, candidateId, model, session);
                model.addAttribute("selectedCountryName", session.getAttribute("selectedCountryName"));
                return "verification";
            } else {
                model.addAttribute("institutes", null);
                model.addAttribute("errorMessage", "Please reselect your desired country");
                model.addAttribute("searchButton", true);


            }

        }
        return "verification";
    }


    public void verificationRequest(String instituteId, String candidateId, Model model, HttpSession session) {
        ProfileEntity profiles = (ProfileEntity) session.getAttribute("profile");

        try {
            InstitutesEntity institutesEntity = institutesService.findInstitutesById(Integer.parseInt(instituteId));
            model.addAttribute("selectedInstitute", institutesEntity);

            List<Country> selectedCountry = (List<Country>) session.getAttribute("countries");

            for (Country countries : selectedCountry) {
                if (countries.getCountryId() == institutesEntity.getCountry()) {
                    model.addAttribute("selectedCountry", countries);
                    break;
                } else {
                    model.addAttribute("selectedCountry", null);
                }
            }


            List<CandidatesVerifiedEntity> verifiedCandidate = verifiedCandidatesService.getVerifiedCandidatesByCandidateIdAndInstituteId(Integer.parseInt(instituteId), candidateId);


            long diffInMillies = Math.abs(new Date().getTime() - verifiedCandidate.get(0).getUpdateDate().getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if(diff>31){
                throw new VerifiedCandidatesNotFoundException("");
            }

            model.addAttribute("verifiedCandidate", verifiedCandidate);


            model.addAttribute("authenticationStatus", "1");

        } catch (VerifiedCandidatesNotFoundException e) {
            try {

                CandidatesVerifiedEntity candidatesVerifiedEntity = new CandidatesVerifiedEntity();
                VerificationRequestEntity verificationRequestEntity = verificationRequestService.VerificationRequestCandidateIdAndInstituteIdAndUserId(candidateId, Integer.parseInt(instituteId), profiles.getId());
                candidatesVerifiedEntity.setCandidateNumber(verificationRequestEntity.getCandidateNumber());
                candidatesVerifiedEntity.setProgram("");
                candidatesVerifiedEntity.setFirstName("");
                candidatesVerifiedEntity.setSurname("");
                candidatesVerifiedEntity.setCertificateNumber("");
                candidatesVerifiedEntity.setDateAwarded(null);

                model.addAttribute("initialRequestDate", verificationRequestEntity.getRequestDate());
                model.addAttribute("verifiedCandidate", candidatesVerifiedEntity);
                model.addAttribute("authenticationStatus", "2");
            } catch (VerificationRequestNotFoundException e1) {

                ProfileEntity profileEntity = (ProfileEntity) session.getAttribute("profile");

                if (null == profileEntity.getBalanceAmount() || (profileEntity.getUserType().equals("1") && profileEntity.getBalanceAmount() < 5)
                        || (profileEntity.getUserType().equals("2") && profileEntity.getBalanceAmount() < 10)
                        || (profileEntity.getUserType().equals("3") && profileEntity.getBalanceAmount() < 15)
                        || (profileEntity.getUserType().equals("4") && profileEntity.getBalanceAmount() < 20)) {
                    model.addAttribute("errorMessage", "You Can't Make An Authentication Request: Please Top-Up Your Account First");
                } else {

                    VerificationRequestEntity verificationRequestEntity = new VerificationRequestEntity();
                    verificationRequestEntity.setCandidateNumber(candidateId);
                    verificationRequestEntity.setEnabled(1);
                    verificationRequestEntity.setInstitute(Integer.parseInt(instituteId));
                    verificationRequestEntity.setProcessStatus(1);
                    long time = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(time);
                    verificationRequestEntity.setRequestDate(date);
                    verificationRequestEntity.setRequesterId(profiles.getId());
                    try {
                        verificationRequestService.saveVerificationRequest(verificationRequestEntity);
                        ProfileEntity profileEntity1= profilesService.findUserByUserId(profileEntity.getId());
                        if(profileEntity1.getUserType().equals("1")){
                            profileEntity1.setBalanceAmount(profileEntity1.getBalanceAmount()-5);
                        }
                        if(profileEntity1.getUserType().equals("2")){
                            profileEntity1.setBalanceAmount(profileEntity1.getBalanceAmount()-10);
                        }
                        if(profileEntity1.getUserType().equals("3")){
                            profileEntity1.setBalanceAmount(profileEntity1.getBalanceAmount()-15);
                        }
                        if(profileEntity1.getUserType().equals("4")){
                            profileEntity1.setBalanceAmount(profileEntity1.getBalanceAmount()-20);
                        }
                        profilesService.saveUser(profileEntity1);
                    } catch (Exception e2) {
                        model.addAttribute("errorMessage", "Request Not Successfully Sent");

                    }


                    CandidatesVerifiedEntity candidatesVerifiedEntity = new CandidatesVerifiedEntity();
                    candidatesVerifiedEntity.setCandidateNumber(verificationRequestEntity.getCandidateNumber());
                    candidatesVerifiedEntity.setProgram("");
                    candidatesVerifiedEntity.setFirstName("");
                    candidatesVerifiedEntity.setSurname("");
                    candidatesVerifiedEntity.setCertificateNumber("");

                    candidatesVerifiedEntity.setDateAwarded(null);


                    model.addAttribute("verifiedCandidate", candidatesVerifiedEntity);
                    model.addAttribute("authenticationStatus", "2");
                    model.addAttribute("initialRequestDate", verificationRequestEntity.getRequestDate());
                }
                //@TODO call webservice
            }

        } catch (InstitutesNotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("searchButton", true);

    }


}