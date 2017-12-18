package com.Tunes_Developers;

import com.Tunes_Developers.Exceptions.IncompatibleParameter;
import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.Exceptions.RuleDoesNotExist;
import com.Tunes_Developers.Exceptions.ValidatorException;
import com.Tunes_Developers.Models.ValidationData;
import com.Tunes_Developers.Models.ValidationMessage;
import com.Tunes_Developers.Models.ValidatorItem;
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
    public static ValidationData decodeAndExecuteRule(ValidatorRule vr,List<ValidatorItem> vItems) throws Exception {
        String name = vr.getName();
        String message = null;
        boolean test = false;
        switch (name) {
            case "required":
                test = !Validate.isEmpty(vr.getData());
                if (!test) {
                    message = getMessages().getRequired();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                            new String[]{vr.getField()},
                            message
                    );
                }break;
            case "alpha":
                test = Validate.alpha(vr.getData());
                if (!test) {
                    message = getMessages().getAlpha();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "alpha_dash":
                test = Validate.alphaDash(vr.getData());
                if (!test) {
                    message = getMessages().getAlphaDash();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "alpha_numeric":
                test = Validate.alphaNumeric(vr.getData());
                if (!test) {
                    message = getMessages().getAlphaNumeric();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "alpha_space":
                test = Validate.alphaSpaced(vr.getData());
                if (!test) {
                    message = getMessages().getAlphaSpaced();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "numeric":
                test = Validate.numeric(vr.getData());
                if (!test) {
                    message = getMessages().getNumeric();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "numeric_formatted":
                test = Validate.numericFormatted(vr.getData());
                if (!test) {
                    message = getMessages().getNumericFormatted();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),new String[]{vr.getField()},message);
                }break;
            case "max_char":
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
            case "min_char":
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
            case "char_between":
                if (confirmParameters(2, vr.getParameters())) {
                    if (Validate.numeric(vr.getParameters().get(0)) && Validate.numeric(vr.getParameters().get(1))) {
                        test = Validate.charBetween(Integer.parseInt(vr.getParameters().get(0)),
                                Integer.parseInt(vr.getParameters().get(1)), vr.getData());
                        if (!test) {
                            message = getMessages().getCharBetween();
                            message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                    new String[]{vr.getField(), vr.getParameters().get(0),vr.getParameters().get(1)},
                                    message
                            );
                        }
                        break;
                    } else {
                        throw new IncompatibleParameter(name, vr.getField(), vr.getParameters().get(0));
                    }
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "digits_between":
                if (confirmParameters(2, vr.getParameters())) {
                    if (Validate.numeric(vr.getParameters().get(0)) && Validate.numeric(vr.getParameters().get(1))) {
                        test = Validate.digitsBetween(Integer.parseInt(vr.getParameters().get(0)),
                                Integer.parseInt(vr.getParameters().get(1)), vr.getData());
                        if (!test) {
                            message = getMessages().getDigitsBetween();
                            message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                    new String[]{vr.getField(), vr.getParameters().get(0),vr.getParameters().get(1)},
                                    message
                            );
                        }
                        break;
                    } else {
                        throw new IncompatibleParameter(name, vr.getField(), vr.getParameters().get(0));
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
            case "ip":
                test = Validate.ipv4(vr.getData());
                if (!test) {
                    message = getMessages().getIp();
                    message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                            new String[]{vr.getField(),vr.getData()},
                            message
                    );
                }break;
            case "exists":
                if (confirmParameters(2, vr.getParameters())) {
                    test = Validate.exists(vr.getParameters().get(0),vr.getParameters().get(1),vr.getData());
                    if (!test) {
                        message = getMessages().getExists();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "unique":
                if (confirmParameters(2, vr.getParameters())) {
                    test = Validate.unique(vr.getParameters().get(0),vr.getParameters().get(1),vr.getData());
                    if (!test) {
                        message = getMessages().getUnique();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "in":
                if (confirmParameters(1, vr.getParameters())) {
                    int nbItems = vr.getParameters().size();
                    String [] items = new String[nbItems-1];
                    for(int i=1;i<nbItems;i++) {
                        items[i-1] = vr.getParameters().get(i);
                    }

                    test = Validate.in(items,vr.getData());
                    if (!test) {
                        message = getMessages().getIn();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "not_in":
                if (confirmParameters(1, vr.getParameters())) {
                    int nbItems = vr.getParameters().size();
                    String [] items = new String[nbItems-1];
                    for(int i=1;i<nbItems;i++) {
                        items[i-1] = vr.getParameters().get(i);
                    }

                    test = Validate.notIn(items,vr.getData());
                    if (!test) {
                        message = getMessages().getNotIn();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "same":
                if (confirmParameters(1, vr.getParameters())) {
                    test = Validate.same(vr.getParameters().get(0),vr.getData());
                    if (!test) {
                        if (findItem(vr.getParameters().get(0),vItems) != null) {
                            test = Validate.same(findItem(vr.getParameters().get(0),vItems).getData(),vr.getData());
                        }
                        if (!test) {
                            message = getMessages().getSame();
                            message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                    new String[]{vr.getField(),vr.getParameters().get(0)},
                                    message
                            );
                        }
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "required_with_all":
                if (confirmParameters(1, vr.getParameters())) {
                    int nbItems = vr.getParameters().size();
                    String values = "";
                    test = true;
                    for(int i=0;i<nbItems;i++) {
                        if (Validate.isEmpty(findItem(vr.getParameters().get(i), vItems).getData())) {
                            test = false;

                            values = "";
                            if (nbItems > 1) {
                                for(int j=0;j<nbItems;j++) {
                                    values += vr.getParameters().get(j);
                                    if (j < nbItems - 1) {
                                        values+=" and ";
                                        break;
                                    }
                                }
                            }else{
                                values = vr.getParameters().get(i);
                            }
                        }
                        if (nbItems > 1) {
                            values += vr.getParameters().get(i);
                            if (i < nbItems - 1) {
                                test = !Validate.isEmpty(vr.getData());
                                values+=" and ";
                            }
                        }else {
                            test = !Validate.isEmpty(vr.getData());
                            values = vr.getParameters().get(i);
                        }
                    }
                    if (!test) {
                        message = getMessages().getRequiredWithAll();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),values},
                                message
                        );
                    }
                    break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "required_without_all":
                if (confirmParameters(1, vr.getParameters())) {
                    int nbItems = vr.getParameters().size();
                    String values = "";
                    test = true;
                    for(int i=0;i<nbItems;i++) {
                        if (!Validate.isEmpty(findItem(vr.getParameters().get(i), vItems).getData())) {
                            test = false;

                            values = "";
                            if (nbItems > 1) {
                                for(int j=0;j<nbItems;j++) {
                                    values += vr.getParameters().get(j);
                                    if (j < nbItems - 1) {
                                        values+=" and ";
                                        break;
                                    }
                                }
                            }else{
                                values = vr.getParameters().get(i);
                            }
                        }
                        if (nbItems > 1) {
                            values += vr.getParameters().get(i);
                            if (i < nbItems - 1) {
                                test = !Validate.isEmpty(vr.getData());
                                values+=" and ";
                            }
                        }else {
                            test = !Validate.isEmpty(vr.getData());
                            values = vr.getParameters().get(i);
                        }
                    }
                    if (!test) {
                        message = getMessages().getRequiredWithoutAll();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),values},
                                message
                        );
                    }
                    break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "required_with":
                if (confirmParameters(1, vr.getParameters())) {
                    int nbItems = vr.getParameters().size();
                    test = false;
                    String values = "";
                    for(int i=0;i<nbItems;i++) {
                        if (!Validate.isEmpty(findItem(vr.getParameters().get(i), vItems).getData())) {
                            if (!Validate.isEmpty(vr.getData())) {
                                test = true;
                                break;
                            }
                        }
                        if (nbItems > 1) {
                            values += vr.getParameters().get(i);
                            if (i < nbItems - 1) {
                                values+=" or ";
                            }
                        }else {
                            values = vr.getParameters().get(i);
                        }
                    }
                    if (!test) {
                        message = getMessages().getRequiredWith();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),values},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "required_without":
                if (confirmParameters(1, vr.getParameters())) {
                    int nbItems = vr.getParameters().size();
                    test = false;
                    String values = "";
                    for(int i=0;i<nbItems;i++) {
                        if (Validate.isEmpty(findItem(vr.getParameters().get(i), vItems).getData())) {
                            if (!Validate.isEmpty(vr.getData())) {
                                test = true;
                                break;
                            }
                        }
                        if (nbItems > 1) {
                            values += vr.getParameters().get(i);
                            if (i < nbItems - 1) {
                                values+=" or ";
                            }
                        }else {
                            values = vr.getParameters().get(i);
                        }
                    }
                    if (!test) {
                        message = getMessages().getRequiredWithout();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),values},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "before_date":
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
            case "after_date":
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
            case "equal_to_date":
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
            case "before_date_time":
                if (confirmParameters(1, vr.getParameters())) {
                    test = Validate.isBeforeDateTime(vr.getParameters().get(0),vr.getData());
                    if (!test) {
                        message = getMessages().getBeforeDateTime();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "after_date_time":
                if (confirmParameters(1, vr.getParameters())) {
                    test = Validate.isAfterDateTime(vr.getParameters().get(0),vr.getData());
                    if (!test) {
                        message = getMessages().getAfterDateTime();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            case "equal_to_date_time":
                if (confirmParameters(1, vr.getParameters())) {
                    test = Validate.isEqualToDateTime(vr.getParameters().get(0),vr.getData());
                    if (!test) {
                        message = getMessages().getEqualToDateTime();
                        message = EngineDecoder.replace(EngineDecoder.getParameterDetails(message),
                                new String[]{vr.getField(),vr.getParameters().get(0)},
                                message
                        );
                    }break;
                }else{
                    throw new MissingParameter(name,vr.getField());
                }
            default:
                throw new RuleDoesNotExist(name,vr.getField());
        }

        return new ValidationData(test,message);
    }

    private static ValidatorItem findItem(String name, List<ValidatorItem> items) {
        for (ValidatorItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    private static boolean confirmParameters(int number, List<String> parameters) {
        if (parameters != null && !parameters.isEmpty() && parameters.size() >= number) {
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
