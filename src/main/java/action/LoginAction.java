package action;

import java.util.Iterator;
import java.util.Set;

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
import dto.Rol;
import dto.User;

public class LoginAction extends org.apache.struts.action.Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm loginForm = (DynaActionForm) form;
		String userName = loginForm.get("userName").toString();
		String password = loginForm.get("password").toString();

		UserConnections users = new UserConnections();
		User u = new User(userName, password);
		if (users.validUser(u)) {
			Set<Rol> roles = users.getUserRole(u);
			if (roles != null) {
				Iterator<Rol> iter = roles.iterator();
				for (Rol s : roles)
					if ("ADMIN".equals(s.getRol()))
						return mapping.findForward("success");
			}
			return mapping.findForward("fail");
		} else {
			return mapping.findForward("fail");
		}
	}
}
