package sample;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServlet extends HttpServlet {


	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HashMap<String, String> address = new HashMap<String, String>(){
			{put("4000858", "<br>山梨県甲府市相生</br>");}
			{put("4000867", "山梨県甲府市青沼");}
			{put("4000862", "山梨県甲府市朝気");}
			{put("4000023", "山梨県甲府市愛宕町");}
			{put("4000061", "山梨県甲府市荒川");}
		};


		resp.setContentType("application/text;charset=UTF-8");

		String ad = req.getParameter("zipcode");

		boolean ch = false;
		for(String key : address.keySet()) {
			if(key.startsWith(ad)){
				//System.out.println(address.get(key));
				OutputStream os = resp.getOutputStream();
				os.write(address.get(key).getBytes());
				os.flush();
				ch = true;
				//break;
			}

	    }
		if(!ch){
			OutputStream os = resp.getOutputStream();
			os.write("該当する住所はありません｡".getBytes());
			os.flush();
		}
	}
}
