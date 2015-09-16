package action;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import dataBaseConnections.UserConnections;
import dto.User;

public class LoginAction extends org.apache.struts.action.Action {

   
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm loginForm = (DynaActionForm) form;
        String userName = loginForm.get("userName").toString();
        String password = loginForm.get("password").toString();
    	
		UserConnections users = new UserConnections();
        if(users.validUser(new User(userName,password)))
        {
            return mapping.findForward("success");
        }
        else
        {
            return mapping.findForward("fail");
        }
        
    }
}
