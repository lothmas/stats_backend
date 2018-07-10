/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stats.utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLHandshakeException;
import javax.xml.bind.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.util.Map;

/**
 *
 * @author kwk
 */
@Service
public class JsonOrXmlToPojoMarshallingService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * This function reads an xml string and maps variable contents to the
     * corresponding supplied empty POJO fields.
     *
     * @param emptyPojo - An empty POJO(xml annotated Java class) that needs to
     * be populated with data from the supplied xml string
     * @param xmlString - A string variable containing xml data.
     * @return An object containing the data form the supplied xml in the
     * supplied POJO class. NB: You need to cast this object to the actual
     * object type before using it.
     * @throws UnmarshalException
     */
    public Object xmlStringToPojoMapping(Object emptyPojo, String xmlString) throws UnmarshalException, Exception {

        try {

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...) function has started.\n It was supplied : 1) Class : " + emptyPojo.getClass().getName() + "\n and 2) xmlString : " + xmlString);
            NDC.clear();

            StringReader is = new StringReader(xmlString);

            JAXBContext context = JAXBContext.newInstance(emptyPojo.getClass());
            Unmarshaller um = context.createUnmarshaller();

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...) function has successfully completed processing\n xmlString : " + xmlString);
            NDC.clear();

            return um.unmarshal(is);

        } catch (UnmarshalException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...)");
            logger.fatal("Your POJO might be missing the \"@XmlRootElement\" annotation just above the class definition.\n Additional info : " );
            NDC.clear();

            throw new UnmarshalException("Your POJO might be missing the \"@XmlRootElement\" annotation just above the class definition.\n Additional info : " + e.getMessage());

        } catch (Exception e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...) function has encountered a problem. \n Additional info : " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...) function has encountered a problem. \n Additional info : " + e.getMessage());

        }

    }

    /**
     *
     * @param populatedPojo- An POJO(xml annotated Java class) that has been
     * populated with data
     * @return - an xml String populated with data from the supplied POJO(xml
     * annotated Java class).
     * @throws UnmarshalException
     * @throws Exception
     */
    public String pojoMappingToXmlString(Object populatedPojo) throws UnmarshalException, Exception {

        String resultXml = "";

        try {

            StringWriter sw = new StringWriter();

            JAXBContext context = JAXBContext.newInstance(populatedPojo.getClass());
            Marshaller ma = context.createMarshaller();
            ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ma.marshal(populatedPojo, sw);

            resultXml = sw.toString();

            return resultXml;

        } catch (UnmarshalException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.pojoMappingToXmlString(...)");
            logger.fatal("Your POJO might be missing the \"@XmlRootElement\" annotation just above the class definition.\n Additional info : " );
            NDC.clear();

            throw new UnmarshalException("Your POJO might be missing the \"@XmlRootElement\" annotation just above the class definition.\n Additional info : " + e.getMessage());

        } catch (Exception e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.pojoMappingToXmlString(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...) function has encountered a problem. \n Additional info : " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.pojoMappingToXmlString(...) function has encountered a problem. \n Additional info : " + e.getMessage());

        }

    }

    /**
     *
     * @param emptyPojo
     * @param xmlURL
     * @return
     * @throws UnmarshalException
     * @throws Exception
     */
    public Object xmlStringURLToPojoMapping(Object emptyPojo, String xmlURL) throws UnmarshalException, Exception {

        try {

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...) function has started.\n It was supplied : 1) Class : " + emptyPojo.getClass().getName() + "\n and 2) xmlURL : " + xmlURL);
            NDC.clear();

            URL is = new URL(xmlURL);
            JAXBContext context = JAXBContext.newInstance(emptyPojo.getClass());
            Unmarshaller um = context.createUnmarshaller();

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...) function has successfully completed processing\n xmlURL : " + xmlURL);
            NDC.clear();

            return um.unmarshal(is);

        } catch (UnmarshalException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...)");
            logger.fatal("Your POJO might be missing the \"@XmlRootElement\" annotation just above the class definition.\n Additional info : " );
            NDC.clear();

            throw new UnmarshalException("Your POJO might be missing the \"@XmlRootElement\" annotation just above the class definition.\n Additional info : " + e.getMessage());

        } catch (MalformedURLException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...) function has encountered a MalformedURLException. \n Additional info : " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...) function has encountered a MalformedURLException. \n Additional info : " + e.getMessage());

        } catch (JAXBException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...) function has encountered a JAXBException. \n Additional info : " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...) function has encountered a JAXBException. \n Additional info : " + e.getMessage());

        } catch (Exception e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.xmlStringToPojoMapping(...) function has encountered an unspecified Exception. \n Additional info : " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.xmlStringURLToPojoMapping(...) function has encountered an unspecified Exception. \n Additional info : " + e.getMessage());

        }

    }

    /**
     *
     * @param emptyPojoClassForResponse
     * @param populatedXmlAnnotatedPojo
     * @param postToUrl
     * @param keyvaluePairs
     * @return
     * @throws MalformedURLException
     * @throws IOException
     * @throws Exception
     */
    public Object populatedXmlPojoToXmlHttpPost(Class emptyPojoClassForResponse, Object populatedXmlAnnotatedPojo, String postToUrl, Map<String, String> keyvaluePairs) throws MalformedURLException, IOException, Exception {

        Object populatedXmlPojoToXmlHttpPost = new Object();

        try {

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...) function has started.");
            NDC.clear();

            URL url = new URL(postToUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.addRequestProperty("Accept-Encoding", "gzip,deflate");
            conn.addRequestProperty("Connection", "Keep-Alive");
//            conn.addRequestProperty("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");
            conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            conn.setDoOutput(true);

//            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/soap+xml;charset=UTF-8");//;action=\"http://tempuri.org/SubmitBankTransfer\"");
            conn.setRequestProperty("Accept", "application/soap+xml");

            if (null != keyvaluePairs) {

                NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
                logger.info("***************************************************************************The HttpURLConnection(xml HttpPost) parameters : \n***************************************************************************\n");
                NDC.clear();

                try {

                    keyvaluePairs.keySet().forEach((input) -> {
                        conn.setRequestProperty(input, keyvaluePairs.get(input));

                        NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
                        logger.info("HttpURLConnection Parameter Name : " + input + " ;Its entry value : " + keyvaluePairs.get(input) + "\n");
                        NDC.clear();

                    });

                } catch (Exception e) {

                    NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
                    logger.warn("The function \"keyvaluePairs.keySet().forEach((input)\" has encountered an error. Additional info : ");
                    NDC.clear();

                }

                NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
                logger.info("***************************************************************************The HttpURLConnection(json HttpPost) parameters has successfully completed.***************************************************************************\n");
                NDC.clear();

            }

            String xmlRequestString = pojoMappingToXmlString(populatedXmlAnnotatedPojo);
//            conn.setRequestProperty("Content-Length", String.valueOf(xmlRequestString.length()));
            OutputStream os = conn.getOutputStream();
            os.write(xmlRequestString.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String populatedXmlPojoToXmlHttpPostResponseString = "";

            while ((output = br.readLine()) != null) {

                populatedXmlPojoToXmlHttpPostResponseString += output;

            }

            populatedXmlPojoToXmlHttpPost = xmlStringToPojoMapping(emptyPojoClassForResponse, populatedXmlPojoToXmlHttpPostResponseString);

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...) function has successfully completed.");
            NDC.clear();

            return populatedXmlPojoToXmlHttpPost;

        } catch (MalformedURLException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...) function has encountered a MalformedURLException.\n Additional info: " );
            NDC.clear();

            throw new MalformedURLException("The JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...) function has encountered a MalformedURLException.\n Additional info: " + e.getMessage());

        } catch (IOException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...) function has encountered an IOException.\n Additional info: " );
            NDC.clear();

            throw new IOException("The JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...) function has encountered an IOException.\n Additional info: " + e.getMessage());

        } catch (Exception e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...) function has encountered an unspecified Exception.\n Additional info: " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.populatedXmlPojoToXmlHttpPost(...) function has encountered an unspecified Exception.\n Additional info: " + e.getMessage());

        }

    }

    /**
     *
     * @param populatedJsonAnnotatedPojo
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws UnmarshalException
     * @throws Exception
     */
    public String populatedJsonAnnotatedPojoMappingToJsonString(Object populatedJsonAnnotatedPojo) throws IOException, Exception {

        String pojoMappingToJsonString = "";

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        try {

            pojoMappingToJsonString = mapper.writeValueAsString(populatedJsonAnnotatedPojo);

            return pojoMappingToJsonString;

        } catch (JsonProcessingException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonAnnotatedPojoMappingToJsonString(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.populatedJsonAnnotatedPojoMappingToJsonString(...) function has encountered a JsonProcessingException. \n Additional info : " );
            NDC.clear();

            throw new IOException("The JsonOrXmlToPojoMarshallingService.populatedJsonAnnotatedPojoMappingToJsonString(...) function has encountered a JsonProcessingException.\n Additional info : " + e.getMessage());

        } catch (Exception e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonAnnotatedPojoMappingToJsonString(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.populatedJsonAnnotatedPojoMappingToJsonString(...) function has encountered an unspecified Exception. \n Additional info : " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.populatedJsonAnnotatedPojoMappingToJsonString(...) function has encountered an unspecified Exception. \n Additional info : " + e.getMessage());

        }

    }

    /**
     *
     * @param emptyPojoClass
     * @param jsonString
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws IOException
     * @throws Exception
     */
    public Object jsonStringToPojoMapping(Class emptyPojoClass, String jsonString) throws JsonProcessingException, IOException, Exception {

        ObjectMapper mapper = new ObjectMapper();
        Object jsonStringToPojoMapping = new Object();

        try {

            NDC.push("JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...) function has started.\n It was supplied : 1) Class : " + emptyPojoClass.getName() + "\n and 2) jsonString : " + jsonString);
            NDC.clear();

            jsonStringToPojoMapping = mapper.readValue(jsonString, emptyPojoClass);

            NDC.push("JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...) function has successfully completed processing\n jsonString : " + jsonString);
            NDC.clear();

            return jsonStringToPojoMapping;

        } catch (JsonProcessingException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...) function has encountered a JsonProcessingException. \n Additional info : " );
            NDC.clear();

            throw new IOException("The JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...) function has encountered a JsonProcessingException.\n Additional info : " + e.getMessage());

        } catch (Exception e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...)");
            logger.fatal("The JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...) function has encountered an unspecified Exception. \n Additional info : " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.jsonStringToPojoMapping(...) function has encountered an unspecified Exception. \n Additional info : " + e.getMessage());

        }

    }

    /**
     *
     * @param emptyPojoClassForResponse
     * @param populatedJsonAnnotatedPojo
     * @param postToUrl
     * @param keyvaluePairs
     * @return
     * @throws MalformedURLException
     * @throws IOException
     * @throws Exception
     */
    public Object populatedJsonPojoToJsonHttpPost(Class emptyPojoClassForResponse, Object populatedJsonAnnotatedPojo, String postToUrl, Map<String, String> keyvaluePairs) throws MalformedURLException, IOException, Exception {

        Object populatedJsonPojoToJsonHttpPost = new Object();

        try {

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has started.");
            NDC.clear();

            URL url = new URL(postToUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            if (null != keyvaluePairs) {

                NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
                logger.info("***************************************************************************The HttpURLConnection(json HttpPost) parameters : \n***************************************************************************\n");
                NDC.clear();

                try {

                    keyvaluePairs.keySet().forEach((input) -> {
                        conn.setRequestProperty(input, keyvaluePairs.get(input));

                        NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
                        logger.info("HttpURLConnection Parameter Name : " + input + " ;Its entry value : " + keyvaluePairs.get(input) + "\n");
                        NDC.clear();

                    });

                } catch (Exception e) {

                    NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
                    logger.warn("The function \"keyvaluePairs.keySet().forEach((input)\" has encountered an error. Additional info : " );
                    NDC.clear();

                }

                NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
                logger.info("***************************************************************************The HttpURLConnection(json HttpPost) parameters has successfully completed.***************************************************************************\n");
                NDC.clear();

            }

            OutputStream os;

            os = conn.getOutputStream();

            String jsonRequestString = populatedJsonAnnotatedPojoMappingToJsonString(populatedJsonAnnotatedPojo);
            os.write(jsonRequestString.getBytes());
            os.flush();

            BufferedReader br;

            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            String populatedJsonPojoToJsonHttpPostResponseString = "";

            while ((output = br.readLine()) != null) {

                populatedJsonPojoToJsonHttpPostResponseString += output;

            }

            populatedJsonPojoToJsonHttpPost = jsonStringToPojoMapping(emptyPojoClassForResponse, populatedJsonPojoToJsonHttpPostResponseString);

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has successfully completed.");
            NDC.clear();

            return populatedJsonPojoToJsonHttpPost;

        } catch (MalformedURLException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has encountered a MalformedURLException.\n Additional info: " );
            NDC.clear();

            throw new MalformedURLException("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has encountered a MalformedURLException.\n Additional info: " + e.getMessage());

        } catch (Exception e) {

            if (e instanceof CertificateException || e instanceof SSLHandshakeException) {

                NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
                logger.error("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has encountered a CertificateException.\n Additional info: " );
                NDC.clear();

                throw new CertificateException("java.security.cert.CertificateException: No subject alternative DNS name matching " + postToUrl + " found.");

            } else if (e instanceof IOException) {

                NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
                logger.error("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has encountered an IOException.\n Additional info: " );
                NDC.clear();

                throw new IOException("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has encountered an IOException.\n Additional info: " + e.getMessage());

            } else if (e instanceof Exception) {

                NDC.push("JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...)");
                logger.error("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has encountered an unspecified Exception.\n Additional info: " );
                NDC.clear();

                throw new Exception("The JsonOrXmlToPojoMarshallingService.populatedJsonPojoToJsonHttpPost(...) function has encountered an unspecified Exception.\n Additional info: " + e.getMessage());

            }

        }

        return null;

    }

    public String plainStringBodyPost(String dataBody, String postToUrl) throws Exception {

        String plainStringBodyPost = "";

        try {

            NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has started.\n It was supplied \n dataBody : " + dataBody + "\n postToUrl : " + postToUrl);
            NDC.clear();

            URL url = new URL(postToUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.addRequestProperty("Accept-Encoding", "gzip,deflate");
//            conn.addRequestProperty("Connection", "Keep-Alive");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            try {

                try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                    wr.writeBytes(dataBody);
                    wr.flush();
                    wr.close();

                }

            } catch (Exception e) {

                NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...)");
                logger.fatal("The DataOutputStream wr = new DataOutputStream(conn.getOutputStream()) function has encountered an Exception.\n Additional info: " );
                NDC.clear();

            }

            InputStream is;

            if (conn.getResponseCode() >= 400) {

                is = conn.getErrorStream();

                NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...)");
                logger.error("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has encountered a problem.\n It had responseCode : " + conn.getResponseCode() + "\n and ErrorMessage : " + IOUtils.toString(conn.getErrorStream(), StandardCharsets.UTF_8.name()));
                NDC.clear();

            } else {

                is = conn.getInputStream();

                NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...)");
                logger.info("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has successfully completed.");
                NDC.clear();

            }

            try {

                plainStringBodyPost = IOUtils.toString(is, StandardCharsets.UTF_8.name());

            } catch (Exception e) {

                NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...)");
                logger.fatal("The IOUtils.toString(conn.getInputStream(), StandardCharsets.UTF_8.name()) function has encountered an Exception.\n Additional info: " );
                NDC.clear();

            }

            return plainStringBodyPost;

        } catch (MalformedURLException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has encountered a MalformedURLException.\n Additional info: " );
            NDC.clear();

            throw new MalformedURLException("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has encountered a MalformedURLException.\n Additional info: " + e.getMessage());

        } catch (IOException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has encountered an IOException.\n Additional info: " );
            NDC.clear();

            throw new IOException("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has encountered an IOException.\n Additional info: " + e.getMessage());

        } catch (Exception e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has encountered an unspecified Exception.\n Additional info: " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.plainStringBodyPost(...) function has encountered an unspecified Exception.\n Additional info: " + e.getMessage());

        }

    }

    public String plainStringBodyGet(String dataBody, String postToUrl) throws Exception {

        String plainStringBodyGet = "";

        try {

            NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...)");
            logger.info("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has started.\n It was supplied \n dataBody : " + dataBody + "\n postToUrl : " + postToUrl);
            NDC.clear();

            postToUrl += "?" + dataBody;

            URL url = new URL(postToUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            InputStream is;

            if (conn.getResponseCode() >= 400) {

                is = conn.getErrorStream();

                NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...)");
                logger.error("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has encountered a problem.\n It had responseCode : " + conn.getResponseCode() + "\n and ErrorMessage : " + IOUtils.toString(conn.getErrorStream(), StandardCharsets.UTF_8.name()));
                NDC.clear();

            } else {

                is = conn.getInputStream();

                NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...)");
                logger.info("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has successfully completed.");
                NDC.clear();

            }

            try {

                plainStringBodyGet = IOUtils.toString(is, StandardCharsets.UTF_8.name());

            } catch (Exception e) {

                NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...)");
                logger.fatal("The IOUtils.toString(conn.getInputStream(), StandardCharsets.UTF_8.name()) function has encountered an Exception.\n Additional info: " );
                NDC.clear();

            }

            return plainStringBodyGet;

        } catch (MalformedURLException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has encountered a MalformedURLException.\n Additional info: " );
            NDC.clear();

            throw new MalformedURLException("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has encountered a MalformedURLException.\n Additional info: " + e.getMessage());

        } catch (IOException e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has encountered an IOException.\n Additional info: " );
            NDC.clear();

            throw new IOException("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has encountered an IOException.\n Additional info: " + e.getMessage());

        } catch (Exception e) {

            NDC.push("JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...)");
            logger.error("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has encountered an unspecified Exception.\n Additional info: " );
            NDC.clear();

            throw new Exception("The JsonOrXmlToPojoMarshallingService.plainStringBodyGet(...) function has encountered an unspecified Exception.\n Additional info: " + e.getMessage());

        }

    }

}
