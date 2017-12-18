package com.Tunes_Developers;

import com.Tunes_Developers.Exceptions.IncompatibleParameter;
import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.Exceptions.RuleDoesNotExist;
import com.Tunes_Developers.Exceptions.ValidatorException;
import com.Tunes_Developers.Models.ValidationData;
import com.Tunes_Developers.Models.ValidationMessage;
import com.Tunes_Developers.Models.ValidatorRule;
import com.Tunes_Developers.Utils.EngineDecoder;
import com.Tunes_Developers.models.ConfigModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tunes_developers.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 12/17/2017.
 */
public class ValidatorDecoder {
    public static ValidationData decodeAndExecuteRule(ValidatorRule vr) throws Exception {
        String name = vr.getName();
        String message = null;
        boolean test = false;
        switch (name) {
            case "alpha":
                test = Validate.alpha(vr.getData());
                if (!test) {
                    message = getMessages().getAlpha();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "alphaDash":
                test = Validate.alphaDash(vr.getData());
                if (!test) {
                    message = getMessages().getAlphaDash();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "alphaNumeric":
                test = Validate.alphaNumeric(vr.getData());
                if (!test) {
                    message = getMessages().getAlphaNumeric();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "alphaSpaced":
                test = Validate.alphaSpaced(vr.getData());
                if (!test) {
                    message = getMessages().getAlphaSpaced();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "ip":
                test = Validate.ipv4(vr.getData());
                if (!test) {
                    message = getMessages().getIp();
                }break;
            case "beforeDate":
                if (confirmParameters(1, vr.getParameters())) {
                    test = Validate.isBeforeDate(vr.getParameters().get(0),vr.getData());
                    if (!test) {
                        message = getMessages().getBeforeDate();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "afterDate":
                if (confirmParameters(1, vr.getParameters())) {
                    test = Validate.isAfterDate(vr.getParameters().get(0),vr.getData());
                    if (!test) {
                        message = getMessages().getAfterDate();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "equalToDate":
                if (confirmParameters(1, vr.getParameters())) {
                    test = Validate.isEqualToDate(vr.getParameters().get(0),vr.getData());
                    if (!test) {
                        message = getMessages().getEqualToDate();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "maxChar":
                if (confirmParameters(1, vr.getParameters())) {
                    if (Validate.numeric(vr.getParameters().get(0))) {
                        test = Validate.maxChar(Integer.parseInt(vr.getParameters().get(0)),vr.getData());
                        if (!test) {
                            message = getMessages().getMaxChar();
                            message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                    new String[]{vr.getField(),vr.getParameters().get(0)},
                                    message
                            );
                        }break;
                    }else{
                        throw new IncompatibleParameter(name,vr.getField(),vr.getParameters().get(0));
                    }
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "minChar":
                if (confirmParameters(1, vr.getParameters())) {
                    if (Validate.numeric(vr.getParameters().get(0))) {
                        test = Validate.minChar(Integer.parseInt(vr.getParameters().get(0)),vr.getData());
                        if (!test) {
                            message = getMessages().getMinChar();
                            message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                    new String[]{vr.getField(),vr.getParameters().get(0)},
                                    message
                            );
                        }break;
                    }else{
                        throw new IncompatibleParameter(name,vr.getField(),vr.getParameters().get(0));
                    }
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "email":
                test = Validate.email(vr.getData());
                if (!test) {
                    message = getMessages().getEmail();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            default:
                throw new RuleDoesNotExist(name,vr.getField());
        }

        return new ValidationData(test,message);
    }

    public static boolean confirmParameters(int number, List<String> parameters) {
        if (parameters != null && !parameters.isEmpty() && parameters.size() == number) {
            for (int i = 0; i < number; i++) {
                if (parameters.get(i) == null) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private static ValidationMessage getMessages() throws IOException {
        Path path = Paths.get(System.getProperty("user.home"),".swara","validation.json");

        if (!Files.exists(path)) {
            Files.createFile(path);

            Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
            String data = gson.toJson(new ValidationMessage());
            File.writeText(path.toString(),data);

            return new ValidationMessage();
        }else{
            Gson gson = new Gson();
            return (ValidationMessage) gson.fromJson(File.getData(path.toString()), ValidationMessage.class);
        }
    }
}
