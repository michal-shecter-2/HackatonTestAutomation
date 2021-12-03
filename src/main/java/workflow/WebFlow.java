package workflow;

import extensions.UIActions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;


import java.util.concurrent.TimeUnit;


public class WebFlow extends CommonOps {

    @Step("Synchronization")
    public static void Synchronization(int num){
        Uninterruptibles.sleepUninterruptibly(num, TimeUnit.SECONDS);
    }

    @Step("Login")
    public static void Login(){
        UIActions.SendKeys(login.getUsername(),getExternalData("textPassword_Username"));
        UIActions.SendKeys (login.getPassword(),getExternalData("textPassword_Username"));
        UIActions.click(login.getButton());
        UIActions.click(login.getButton_skip());
    }

    @Step
    public static void Filter(){
        UIActions.click(filtering.getDefinitions());
        UIActions.click(filtering.getAddData());
        UIActions.click( filtering.getFilter());
        UIActions.SendKeys(filtering.getFilter(),getExternalData("textFilter"));
    }
    @Step
    public static void NewUser(String userName,String email,String newName,String password){
        UIActions.click(newUser.getButton_ServerAdmin());
        UIActions.click(newUser.getButton_NewUser());
        UIActions.click(newUser.getT_newUser());
        UIActions.SendKeys(newUser.getT_newUser(),userName);
        UIActions.click(newUser.getT_newEmail());
        UIActions.SendKeys(newUser.getT_newEmail(),email);
        UIActions.click(newUser.getT_newUsername());
        UIActions.SendKeys(newUser.getT_newUsername(),newName);
        UIActions.click(newUser.getT_newPassword());
        UIActions.SendKeys(newUser.getT_newPassword(),password);
        UIActions.click(newUser.getCreateNewUser());
    }
    @Step
    public static boolean Sikuli(){
            try {
                screen.click(getExternalData("serverAdmin"));
                Synchronization(1);
                screen.click(getExternalData("orgs"));
                Synchronization(1);
                screen.click(getExternalData("settings"));
                Synchronization(1);
                screen.click(getExternalData("plug"));
                return true;
            } catch (FindFailed e) {
                e.printStackTrace();
                return false;
            }
        }
}
