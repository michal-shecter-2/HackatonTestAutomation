package workflow;

import extensions.UIActions;
import utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;


import java.util.concurrent.TimeUnit;


public class GrafanaWeb extends CommonOps {

    @Step("Synchronization")
    public static void Synchronization(int num){
        Uninterruptibles.sleepUninterruptibly(num, TimeUnit.SECONDS);
    }

    @Step("Login")
    public static void Login(){
//        System.out.println(name);
//        System.out.println(password);
        UIActions.SendKeys(login.getUsername(),"admin");
        UIActions.SendKeys (login.getPassword(),"admin");
        UIActions.click(login.getButton());
        UIActions.click(login.getButton_skip());
    }

    @Step
    public static void Filter(){
        UIActions.click(filtering.getDefinitions());
        UIActions.click(filtering.getAddData());
        UIActions.click( filtering.getFilter());
        UIActions.SendKeys(filtering.getFilter(),textFilter);
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
//    @Step
//    public static boolean Sikuli(){
//            try {
//                screen.click(serverAdmin);
//                Thread.sleep(1000);
//                screen.click(orgs);
//                Thread.sleep(1000);
//                screen.click(settings);
//                Thread.sleep(1000);
//                screen.click(plug);
//                return true;
//            } catch (FindFailed | InterruptedException e) {
//                e.printStackTrace();
//                return false;
//            }
//        }
}
