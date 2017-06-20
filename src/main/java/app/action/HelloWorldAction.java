package app.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import app.form.HelloWorldForm;

public class HelloWorldAction extends Action {

	public ActionForward execute(ActionMapping mapping,
		                         ActionForm form,
			                     HttpServletRequest request,
			                     HttpServletResponse response) throws Exception {

		if ("th".equalsIgnoreCase(request.getParameter("lang"))) {
			request.getSession().setAttribute(Globals.LOCALE_KEY, new Locale("th"));
		}
		else {
			request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
		}

		HelloWorldForm helloWorldForm = (HelloWorldForm) form;
		helloWorldForm.setMessage("Hello World! Struts @" + new java.util.Date());

		return mapping.findForward("view");
	}

}
