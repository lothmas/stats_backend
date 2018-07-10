package com.stats.controller;


import com.stats.controller.trending.TrendingMasterObject;
import com.stats.trending.model.Trending;
import com.stats.utilities.JsonObjectConversionUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
@Controller
public class LoginController {


    public static String byteToString(byte[] _bytes) {
        String file_string = "";

        for (int i = 0; i < _bytes.length; i++) {
            file_string += (char) _bytes[i];
        }

        return file_string;
    }

    @RequestMapping({"/trending"})
    @ResponseBody
    public String getPage(HttpServletRequest request, Model model, HttpSession session,
                                        @RequestParam(value = "memberID", required = false) String memberID) {
        List<Trending> trendings = new ArrayList<>();
        TrendingMasterObject trendingMasterObject=new TrendingMasterObject();
        String url = request.getRequestURI();
        Trending trending = new Trending();
        trending.setProfilePic(profilePic());
        trending.setTitle("Test Title");
        trending.setDescription("test");
        trending.setOwner("louis");
        trending.setDescription("Voting is a method for a group, such as, a meeting or an electorate to make a decision or express an opinion, usually following discussions, debates or election campaigns. Democracies elect holders of high office by voting. ... There are different systems for collecting votes.");

        for (int a = 0; a <= 3; a++) {
            trendings.add(trending);
        }
         trendingMasterObject.setTrendingList(trendings);
        //return trendingMasterObject;

        JsonObjectConversionUtility jsonConversion=new JsonObjectConversionUtility();
        return jsonConversion.objectToJson(trendingMasterObject);
    }


    String profilePic(){
        return "/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\n" +
                "HBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\n" +
                "MjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wgARCAF8AXwDASIA\n" +
                "AhEBAxEB/8QAGwABAAEFAQAAAAAAAAAAAAAAAAQBAgMFBgf/xAAYAQEBAQEBAAAAAAAAAAAAAAAA\n" +
                "AQIDBP/aAAwDAQACEAMQAAAB78AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAtLll4AAAAAAAAAAAAAAAAAALC9SoALDV8higW97s/L++59d3XXz\n" +
                "7zqNZWX+cnf5vPOlzvfsGa5qLAAAAAAAAAAAANf55uOc6Yydh5pkl9wr536Bm5NRt+Zl4+PHiak3\n" +
                "a6HCvf4+TNdt0nknTXn2PlXovmWdZ0WldXP4O87DY8XK3j1dzu+5byAAAAAAAAAAEc8w1lcO8Z9V\n" +
                "sb1hdBqKnXcfZSK5G+m4+u9C5zn353NbT0ePJnwXTV8Cdls0d9MmLIpgy7ymwchtOn5DHNet5uE7\n" +
                "jFvEoAAAAAAADW7LUJ5bg3EXeYCRaYaZhZkssK3WVNxO5u7PSThtv3zxyLMdmfJFyzW35ybIs0mW\n" +
                "VBzZVmPNZbNjWWbKZqpVei7bzKZjXoKlcaAAAAAAAafcac8+x3Y+vNHzCFbfZKrSsUBdfjrWRbRM\n" +
                "tLa1TLZSW+Thz46Z4MvIc/duIlzHvj3azlz47rMsmPdz69Z1Xl2aX1RxnSszgAAAAANFveX5enn9\n" +
                "P1MfPbmmeJ6fBbgkxbhdjuK1VFbRWipXJZmqlZd2OmK+hctllbJFl1Jq6NJuZ1du4urV3S7Etpkr\n" +
                "WPJS9J3S8rsDuMnI9JlKEoAAFsORjNPC6O3n35fczLbNRq+qp048DA9Nqnk13p2gs462VHspWswx\n" +
                "ypNVi3ZItmSsezWZSLSpVIdsuxz6eYb2fzvRSwub9V8iiRhspYrTLWfYa3ObnpLN/jV4xoAADDF2\n" +
                "FpEpWMZmlmE9EvrPXFeXK1MXO9Naedx/SqWeX19KiHn2HvrLOCt7/GcG7/IefV9Hknmcr0ySef8A\n" +
                "eVrLm5XoMEaWm9rbpJOxskxybsi5M1mWAAAAAAGLKIWHZjSYOiGmi9GNRfsoJWlNebC2FhNlTBpq\n" +
                "6BrI0b5rMRt8ceYRsuwznFWdyOPndEOal7oQJOYUqAAAAAAAAAAAAAAAFtailQAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAA/8QAKhAAAgICAQMDBQADAQEAAAAAAQIAAwQREgUTIRAwMRQVICJANFCQIyT/2gAI\n" +
                "AQEAAQUC/wCP5YLA6t/rs7M+mUdQtWzGvqyF2UgOx+DMqBbUab3/AHFlWAg/i7BEyLGutbUrseiz\n" +
                "Ey0vrDcCDset3UbLstOq2rMbPx8iBjN7/rzb/p8U2F4mZZS+H1dbJ8+vUn4YRj2Ko+pSVXsrLnjW\n" +
                "TkdynF6s3Yx7TdTmvwwgwWc/2/WYvV+3L+pI1deZfijpubdbd/R1u/8A91Mfautk6f1Q0xHWxJ1b\n" +
                "KoWh7meGE8JuxoiiHksS9rBgdSsoa7LpyMYic/Tlpk5k2E2Vo746YHUxfWjrYv8AN1CzuZwOpbX3\n" +
                "F+IrzCzraGyuuO6E7O5WjWn6J1rnLUW553wClwdFZ61et0EWKBCYtxEW+6UWMaum9UrMS1LP5b37\n" +
                "eO3kwMRGKPNViFpufJCamJcgiaerKxIfRihSt6agHo7tm8icOLbnKfM+IDBaktem5sLLGHEdbF/j\n" +
                "6h/gupU+m5v0CT4m4DKsxkjdR5CyzmxE4iDzHoLBcerRZdW1NWwm4DuMsA1KyCWyLSabrVrwciu2\n" +
                "j+LqR1hN5hqE8TSzSzepv2NTbCAeRRzHbopnesMvHiCAwiAagIIHJrC6Unp/UDXk/P8AD1P/AAjN\n" +
                "zwYy69v4hm9QOTO0Aw1N+HxtwgqRA3qruYBpxrhh9TFSVX1Xj3+pn/4j+B8ezv8ADeovKfMI4lYQ\n" +
                "LI2MZ5EBg0Zvyn6zc34rdkOP1d1lOXRf72YQzXYsYFT6P7Q9PiKggUbI8/rqeIphCPGxljoyQECD\n" +
                "4Bg5KN69AfNWfkVSnqqNEdbB7V2+Zjqri2llafMI9B7CeYfldT5KDc+JuLxLkrFBMHyG8/TC+W4j\n" +
                "VntpOCzc2sDrEFZi1UyrjWabe4PYPw6Bw+II2LZOxYJ26r0fpmK0s6KDG6PkCNh5Fc1NfitLQLOJ\n" +
                "acdCbm5sTc5+Q8TjtOCkWTLcGnuQ2znORgiEiLZEt3MPuCz2G+fTU1OM1NGefSzGpul/R5bTZS01\n" +
                "Kkm5yhbwzTc5TlC8LTcBitBZMHG747FXaK6bXpqAei+ZgYfYUezYDOc37GvRlSxb+jVtH6blKzVX\n" +
                "1zmZ3IX3NzZm5v8AALFqsMowL7GrQVpD0rFJ+0Ys+0Y0+0Y0XpmIJ9vxIuPRV6D2ioYGiMtqT6u4\n" +
                "H6lJ3lndWc1nIeup5m5uNXW0OFjGHpmKZ9qxZ9qxp9ox59pxoOl4sHT8URcXHWKiLBC03GbY4iaE\n" +
                "/WGxFC3q05QIWATXvmtGhxKDDgUGfblD3dMe1Ux7q6i2aliWlp3U3ueJxnGcZxnGcZxmhNiWXpUg\n" +
                "yOam06ym6gz025/NrMgyv6kgYuWzJh2QYqQVIJof0EAyzBx7Z9KFWzDyzYVzUUW5gbukR+pWK1ea\n" +
                "HqfOfYymMRMx4uJkGDBSLRWk1/qdCaH/ADn/AP/EACYRAAIBAgUEAgMAAAAAAAAAAAABEQIQAxIg\n" +
                "ITEEMEBBUXATMkL/2gAIAQMBAT8B+r1zJOYqpi8UvgajvPQ3JmqPy1NQzf2J+xszvwsNKqqGYmAv\n" +
                "5snpkTnwFjVr2NzvZPYS+NK8Pkgi3JJG8djpqU6ivo0/1K8Oqhw9SUkZWROyOWP5Inc2RmM5nXoz\n" +
                "InTwU9TiIxMZ4i3tBF5G7y7ckWiyXcgggymUgj7h/8QAIxEAAgEDBQACAwAAAAAAAAAAAAERAhAS\n" +
                "AyAhMDFBcEBRYf/aAAgBAgEBPwH6vgiBOb899J6NXhfJhShx8ECRC73zeqUpKNT93jY0VKOuLRd0\n" +
                "UsVoHz7s5Gvx/OrVfBTrtelNSq5W+Zv/AC8GJizEajc9KllNGPl5vAleEQjwTm02b7JJMjIyMiSf\n" +
                "uD//xAA3EAABAwEFBQYFBAEFAAAAAAABAAIRIQMSIjFRECBBYZETMDJAcYEEIzNCoRRQUsGQJHKC\n" +
                "seH/2gAIAQEABj8C/wAP9TCoQf26G1tD+FLm9pqTmpaf/Fq3elxgLPz9XAKh3S45ASnPdmfwvTiu\n" +
                "0ZT+1PUaKnhUjcc9roY2jAsbGvHKhWEw7TIrUecc8eLIIucSSsDyEG21D/LcfzoqKCUKLtGQORVW\n" +
                "V5FTZOex7a+q+c3FwKbaFsSrZwzuFZZIwqmCrjpfzRayRPEGEJNpBy7QUUWjpk+ZZZcGidhB2XLS\n" +
                "tn/0g5hkHYbIux6BaDZAbXXYL2alriIzlXbRpKFjaS6y4FW9m3O4TCk0Wg2QBA1V4FXZ9k3spDm1\n" +
                "lRbwy0GvFXmmR5e1dzjZI8Q24DTiOCuWDbp4uUkydkMEqfFsyVAPdfMsvdqkcE4C0EPpe/pXnNPr\n" +
                "u0zVI9FLgJ4L9PbDs3j8o3HTHlbR/wDFpO5jbVUZ1XLTbVXComsq83bdcVS9VXnEz6IhtoI0Cg8N\n" +
                "5sk4a0UGzdf4FNaQTZ5OcOCDmkFp4+UteYhV3q7larwk+6mI2wg0RAzKEvg8lDXNXLXevHgobhCN\n" +
                "+0w6BNaHy4Cvk3eo2Sqt72iqUYAk/hYsbtFRrWt5qezuu1GR3c1BTbowhYALxUfEG4w05eSd6jbX\n" +
                "yGpWSrXkps+igiDtoqLRGPyq8U2ye3CMiFNm8HyDtyO+qp1QE7D/AEoIXyzeUHZzVOq5rQqM1hoR\n" +
                "xUWwvjULA8Toe+unIKbPooIg7Z7ylSpOeyBwRzlCVRpjXZBGFYHdVl7qFFFqqZKJWgVELrz6OUWj\n" +
                "Y5hS1wI7szsxCVQSO95IQ0QpK4+yNVRZKqjgiOCylZwpDSDqsRG2FkNuSllCufdVCoYXArwqbSyb\n" +
                "PMKjLvoVgteoVLrvdYrJ2/UKLqyjuI2UGw9ziYQOfk8dmCpsHf8AFyi0YW7b7vYd9ftJucOaczsx\n" +
                "dIqjXehX3j5h/HdSFWnr3d17QRzU2Lrh04KOzkagrFZuHt3lGOPshLC1vElBrRAGwnF1X39V9/Vf\n" +
                "f1XgJ9SvohYLJo9u8qFhKyvKLT4V45jZms1mO4qxp9l9Fq8B6rJ3VZO6rN/Vfd1XhPVfS/KpYs6L\n" +
                "CwD23I3JJCEZarVVp5CrQV9MLIj0KvNtbQFXf1Dh6BBt+/HE8V9Brmf7qqHWbmHmovCfXvLzkHDI\n" +
                "rC0n0Tf09iQ0a8V/qLJ0cgvl2Np7hVsfynFzhXIaKrwsWJUaPM1CxWQKDWGAMles/ig0fxurwstD\n" +
                "rkgH/C01DlUEeyIHwtoRqr7gWH+JXy7Iu9lSxtEbzOOqxWjW+gWNxcqNH7Vksv8AHP8A/8QAKxAB\n" +
                "AAICAQMDAwMFAQAAAAAAAQARITFBUWFxEIGhMECRILHRUJDB8PHh/9oACAEBAAE/If7P4Vl5MJvx\n" +
                "j/TqEwODgdWGqZf4CDbhzmnynWfvECwbP00m9Rmk/IqA0b+++chgtgnb9Kv0pTrJNdHSLhrg5hJ7\n" +
                "cjxhg44TblqoVxcC4s9XBcuQhoX7+ZX0rbBiO5IALfMQAsbPu2SB8mNdRbLmj2ZSM6TXvBAI2PPr\n" +
                "5kIZjIszKJPBFKWxqUpw5w3F/ALOHxi68MQGejsX5nMyw7RNcUeamSyBXiWUGH8yyDSdNkpDdKma\n" +
                "nlSgfEUOdrFERi2tHj7lqzsDuzL2YtkDGHcfEW/PhDy6yeg/24mSvMwB5OZriZOG1T5ud2XH1CUp\n" +
                "zCaq5EpROvSEQIrkCIg1uOSOFtPlikAXoS+kV/EhDwBq9QDYVnsYYdJHMbptdAQDaeft81WXHtiX\n" +
                "q4n/AEklqplEtl3M2mQjN114jq582xi21fBMmbBrg8RUaSZ20xeK3ZFgrTaVKAIJLm8sR2d0xTLq\n" +
                "0XmWex1Yrz3ijTsxEcITsvHcZCX0/aEBccXU4sX019rX+wPxFYu301Libdeo3DeXyjJSh0I8YXQF\n" +
                "sBWh7TCAdMVMvAsMWsrUR5xzBTSZg1F34cYBR1Fw/hBoSglf+jFsOV7SvOYd0vG3U2pMynEJbOU7\n" +
                "pUZeLJeOjYecyV0A/aaV1+4ZQvy9LlpaZXGZyOu0sNBHOONjK4VO8oLZ3gGotmiA4ZW6gDxeKjiH\n" +
                "IjlYCoHlRO4deYyvL0NRQpAFMTr7npSP/vlaaeWK9T7FzUaY7/59n/szcpsQ2B7cRL0BO2/mUcL5\n" +
                "nEYjNys+g+o9Z1GpScc8x213a8TtsC8IbbsoY/uhAWgTEGKHpyQONR9sGUBsleuPmYSNQOpb5slu\n" +
                "3GYIBGx5+zAVEir2a/RXqfouOocROWyD02Dviahab1FQLX3lBY8MKm9hfNiFwcMUom8wrWFzFrWW\n" +
                "Kym9oggeEdM4NgnjIeT7AAVypX59Ky5dlobV6X6E3D9C4NSq0+SUz/HrLUrWhCzsSl3/ADE0UoOF\n" +
                "DgydeZaup0dxFoR6MScDA4hWjF54EaGrt3hQSyGAGvN4liTxrUBxTtMN+MH629wVFtQrqiFXQZcu\n" +
                "CFlzj9N+ihsJdkPUrREcvXGAM9TrEWG2twcxFcnWNJVR23Fq2B7iEZtjDY4Wf5lntcphb/KAdEsC\n" +
                "lnmBbVLnpHmO+4Vpwd9IODKr1ilnQEcFDzEYvPkbJ3bkP06aOVizKgMIruGNjThlUSUP0AQIFXXe\n" +
                "9ZcEnCufeVLT08QBmsIpLCbNHHMLJYDUxLaMeZcrdL3xN4G2Zo0HJGulB1hd7LsMHVDhNMCra+Yd\n" +
                "z8ylaVGmmNEODvKZ/wAxGefeM4VcjN/pv6LqKYSRW/yzAa/JFw3szhgAhyM82ouss052l+1yk1qO\n" +
                "xcvefTUrMxOL0RKNZ0ihk7sdX3IGhR9pecYnZCeoRO42tzqHQMV3j2GPMoaqgcQ23zPKYqIviKcx\n" +
                "NzlI4blwC1eCHVdsfRenqiPpX9DwntD6S61TEBu/6bnvcBLhydQ7Nn4IVjNcWzmwHqll5lmKYJdd\n" +
                "kEJlGkE3KxTDK9ZXqCWQC1ghYgsv0aFFpxDAqt4ikuWy/wBFejJHCFwJds6jMafWaVM+ZqK3PoaF\n" +
                "3GVvRfaZlLOxc+J5zN3+DKgAqr9K2Zt+ke7Ei/vsYf8ATmYT6mUK6Q4+lVCSdtmmY7Qrz3suUXal\n" +
                "Xx0m/HF/Ey6/mF1Zji4Jpl+iGINS3JKT5eBN/wCyVOAPD9RpehQBy4Fy+Z44+VP5YJ8IUKYtykFg\n" +
                "wjTLHSUQCJcr2TsVdAl9XhC2b+tVz57ibf25rPLZcNJW7mArd3Q/EyrTV2fKOK4tKQ8iHtfDKrz6\n" +
                "IoylEenzlust1lus8pRzK+ksBRdGJYEMxct/a0rB7OKqXt/jPEkZ0l41maAVXZp0gdbwS0XacOpo\n" +
                "1AtH3AlA+hVjDlCrmKM7XIMOwoqoNzbr2j8hFDh52xfxCfJOwhgdTyJsd5JagykvQ6RzCdJIRbOv\n" +
                "pSAaP6RR0nafidp+JQcf25v/2gAMAwEAAgADAAAAEPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP\n" +
                "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP\n" +
                "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPNPPPPPPPPPPPPPPPPPPPNPOKeu/M9vvPPPP\n" +
                "PPPPPPPPGccf9rpEWACVdvPPPPPPPPPOFRHu9FsykG2S5svPPPPPPPPL+lx5um4pZ3rNiSMfPPPP\n" +
                "PPPPi7WKhhN0Yk78rAf2tvPPPPPMKJVzezrqcvdBC9AXK2fvPPPLex7L63jq7/8ARog77+lRnzzz\n" +
                "zj64CAAjSJmbZJll9gcg7zzzzzxwyzxroYzI7paywxxzzzzzzzzzzzzzzyyzzzzzzzzzzzzzzzzz\n" +
                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz\n" +
                "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz\n" +
                "zzzzzzzzzzz/xAAmEQADAAIBBAAGAwAAAAAAAAAAAREhMUEQIDBRYXCBsdHwcZHB/9oACAEDAQE/\n" +
                "EPle7SIz3r6fvI/PjolXCTLI3zNyTQnRbyUUSnUxtoMUBCiMezDKPEjL5HkTmB5MiY+IYTnK49/F\n" +
                "dFZpWmNjHPQneyDxMTKio30Xxf6HNWzJFldjLy6aHkxpYGbVmPDL3zpLhFhLkdbU/sy0NCVRCRaW\n" +
                "dCv2eBzb9GbafYknuogsT6UUJZb3+/kfIM0l+P2I9CbEkGEr0KFG2Olw6CR67U21RyN/kWEqq9ER\n" +
                "A24NbIL2MMQ22UStMTYrgNkTohHPkjuTIlCfN/8A/8QAIBEBAQEAAQQDAQEAAAAAAAAAAQARISAx\n" +
                "QVEQMGFwcf/aAAgBAgEBPxD+XujJ+fZaO5CP3HiUXMhBsGFpwNhmgkUTfZICN9yzd0sfsHIHIjg5\n" +
                "uPE0A2UzxfMb7kd72Eg9w+oX3Dmbas+o7yrG/UcfHLJADC4JC7kweDdrdjht1rzGPfn6TvbPQW/G\n" +
                "53jj/LS3Ibe5sn3J1ocbjDsJpNvRuThb5u0d5uTrCbVtLl6WCY3hsjbq21j2+eUPmAsvYX4Tg2Ca\n" +
                "Hw234OrbekVvoercpi1tll+vbbS0tLS225uf6P8A/8QAKxABAAICAgIABQQCAwEAAAAAAQARITFB\n" +
                "UWFxgZGhscEQQNHwMOEgUJDx/9oACAEBAAE/EP8Ax/qBuyI0GGMD/wBdf8ZYvlEcdHLD2MBKvvLQ\n" +
                "BxVTJUKOT6HEK7bkVv8AkIGMmk/4uBba0QdXA5e3q4VZDsb/AHywJPWfeeQJKz/jfuY+AuWu37LB\n" +
                "0PAfW2LawsoHKN5PVa6mIwgwN9B8eZdvGTmeQhwCFifqhE0BawhyWkIYc8WrcSGZsWPWn6Tgf5Kj\n" +
                "4c/C4KT5seyFRJyfu1TirOzweC34ReIyvaysrb1Ps0xdJ4N98OPevUOsKwNifqji+C8v+pgLdiXd\n" +
                "7+EIDhWG1+Maw7tGz6Q84QBofd5mfQNgH1qXLSpoHnJVzATwVKftfhmWUIexbDnszEyS0nCofVh4\n" +
                "gAKaezXME4NAlI8TOPrLa9UjGX/SAflw+4wFalxPg2hhuJB/vZ8ICdXK0Bfgx9f3Ls6Zv6aPrDwu\n" +
                "zq/DNyw+ULVSN8aqu/L4eIafrXY/o4JkWUb9MX5zErOBWxLKDmsvPUz5exKVAyBoWLz8YTloR5e1\n" +
                "vEvdrRKK/pEJBxs+bj6wnpBC9o8HS+o+WCEEjYXe6jWwccHqBUWAOX2/iZiEOfzGOYBUteyyxIEi\n" +
                "wcdqkK7WizuJKJU2PBvvMI0d/Eovnshx7lDx+3pqixfGD7S8W2nqUVVVB169y3BEaR4jvdSzOy8v\n" +
                "2de5qJRPYtx7jX6U957mHG/7/eJRysqYC9roj0tTfzm34VFdV4xLOBqwNMpyiUaPlBuIpBd8YjTj\n" +
                "JanFxkKn2R2g/WiBQXkRz+CKuWYtWD0R7Q0wnF+D+Y6vHsOyIBXswikHVHDWdviE3auMpe52RPn2\n" +
                "lXO7dLFc/H1Ea/D+1b6wKEkVAqWvcXY6im4cOyDD6RfMbjF1vL1KfhoaCYqYDjqG1EzQf3zlhJR0\n" +
                "yXj5/aNg43QL8hh3tgS+TQ0AxG2AUPpYdnTMsKPMBluLr3EZBZbWzxcpP8pvasxOkdTYNWHUZ98p\n" +
                "KSujv4aiTGo2NP5gWW0KKxXqOOIqTmFDAaRG0d7jditVSrFdsNECjlfnMRLQIpGqGy3PUEuGVCe/\n" +
                "2iQSo2OgH6Mc5L0NMamDcAd/3+/0i2eJpBR1mM6A4bf4+8F6Xg/PfxjOGoXR8GrlnhhtSephkShx\n" +
                "BMnjtZh78zCLTkbp+kLna7y3HwFDIafUxGodY+sLUi1434ZYdwEbh5TLKuC1zPT2TRmNTqfIy9RG\n" +
                "Fg65INW7Tt1KKQCjzFbZNgWfmMtVhUc7a38oecm18x3wGWP7JKDSh9EQoTfiJXldX/8AqG+SFY+c\n" +
                "UbPXamVvqEpxW8Rmq1LN7lOEqnLKNXLdZzM4fnKxMh86jXk7de4maBcqa6hZZ04vomYR6bRyPliJ\n" +
                "jtZi4casAPzSntLaf4fvMfwikrU2bGIMrWnn4y1FeA6ia4c3k+MFKXDQvn4xy3E0Z2p4I3GKPKCm\n" +
                "Dr4wywrA2J+xN+L70eWAvOOoOgM8sz4vR3M5lW+uYV1KLxcd3+YMYmDPcEZzkB+027TzLdK85goE\n" +
                "I469xAQ8oEu/pA/J6mbaAmWHvqEBYA557/1EER3dSecfeBXYGoeB/mJCCkMkHdsTFycjzEAI1yde\n" +
                "oMOA5L2QyrXVDX/wg33rdsMczH4Q2LPONfOFB3gjgR3XuUnBsNewcn7AOhVu6D9ossK/0IfQ/SKy\n" +
                "47i4hkcxTNRTZmC1sO4KFm/EHEwahcqWnvi47m8jftxxLVW8A261OIvcuAOL7JyE9lZ1uVYLjy47\n" +
                "nghMqqBw3z3vcsjzhh65l4gdlQ/DHo3sKSE0vzga6eYpDxluXdQeJeyZArwXB855/mJRIt4/Pzlk\n" +
                "WC02B/EKIOz7mSqJHhfWn6QTaW8X8Hfw/wAy4C4Dq3cW3bLUnpg5hsKYmOPUJQGHCeYadTbqDeGz\n" +
                "7Qxx/uG/XBL5g5/iVqrzHwtRLKXMA3NvWpZxPYXkhDiWwLYdBLVEpa1bmmJETZaBis8zboqsi8MD\n" +
                "XZmdO6lqoi0GiJ2tu0FIBNmmRT44RlqBtRJ6szcv6VuSAO6TiJTZtZy+ZXyvyK+LqYEC5VdI1Kab\n" +
                "MFxBOi27eDG5cbQy0zGWQhTTHSfgPsXUHCoWh+zZ9YMUO1/icCzN4Y55iCSLunKZPjLEI3TKeJYA\n" +
                "hsSkiFXDrw9xlsqpeZk1Kr3A8S20hreZyS31KFRxAdhxMI6IBY81g+3KDHJ4WX+02fGho79ysuYM\n" +
                "0+45KHBpBWVadh5mgKyGsCjJzD1wuWKvH+5TNALG/lxCFxwqTj3uLyUYGEXSQO0JeDydQKS4GvwO\n" +
                "Gb9zFwYPGRtF1K6zBScVAVoqsE0iaARH6aTp/wAxS5XJpZ+s4YER/WApQ43J3/htu3BGnmIiC+OF\n" +
                "Iq43in3l5ZaIOSOdZRFH3VwlU3KPo2S8SO7d/Edw5sRrIfnHFKc0PpEEBExSanxUcR41FEBS3iXV\n" +
                "96fL6joNhSz2ykcTdLk6CWStMV93iYMi1r7mXwdKB4wauVBsTCtuOYoKDjFkLWlVVRVaFMqNS7Gy\n" +
                "kRvZBgvWbt/MwArKJd+7hAsATAdGD0kKbjqrzKpaZBUXsxAbQ9nUUUlQFqwwp2KAf8KU6EWIMRxA\n" +
                "fEejEdL+jQ2IPDC1Q40PiZndo8nw/lE77jU+nTKrr1L1wjK8RX2iHt8wOUwOZk73MsvCxNI41KFr\n" +
                "txKNF4uWONRQVGi7iAyx0js5jALtISohpdW5z1HFRuFK55YmBFB9MRy3ieIKGZY6gaSqAMrKHgsa\n" +
                "sLwee2PIWvJX+FRdsDaQPB40yzTEcfoF9lS5f6UeJV1K8hDQVSZH5xNFZru9cn1lZBVkOjdM0CnK\n" +
                "V85dFzwyzZCfEylShVMrNMv0wbymbdQ3IzgXoSjymrH4mE+KWJ4HKx7ggAoglN1Xh/MSl7LPl9Tw\n" +
                "/wB/UNP0X8QKZx8P4i9vgo+1RlcPT/KVwDoD8zAND5JKLVv/ABOmLhIm16j/AKhSiO4v4mpyKBDv\n" +
                "iVsMNvggX6wvsFg/d94YDbnfQt+mYt9wpsmpH0wLzCCTarOog5ZcU/UgLm+5LGpfP4E1/wDbOY2a\n" +
                "vjlpQPm0W4N1T+IZn2j/ABNn7ZKPS7n5mmz2/klH8Hz8RKxiEPyq7gReA7xKw44UZ335/pue/Exs\n" +
                "AcrLA2tFISlONKZZqsUj7xS0X0/zI2B9wlDnpZfU7u6VveoDms5FsrvrEbxYFJTpE8SrDBRXHmkb\n" +
                "WziebbMK8Y6AzfG4SyroHwBzF0QauB+UrbI9CJj0YrhTPhTz55MBy/nOQmdu3uUSuOQu/wASp2Mi\n" +
                "lPUZc1asX1dEELLVoc6FoNQFizLON+9VD1ZaEA+8qe/iKX8Rz62GHUrc0FdX/Vl43IAy7qCAAdE0\n" +
                "IfuFwB4SWVw5zcubPbQBou7lMAAA92bcytKXa1fgu5gYoZV3hmWnmqH4ikxBYR2FsS2GksND4M3L\n" +
                "ZTyF82JoxVgJb1uLhcxgRxQ6JeEPYfmzQli+D4QQCVylwOgDwSv+moi2w/CX7+WlP8aGoD0f+c3/\n" +
                "2Q==";
    }

}