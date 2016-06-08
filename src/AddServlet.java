
import Client.Message;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	private MessageList msgList = MessageList.getInstance();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException 
	{
//		InputStream is = req.getInputStream();
//        byte[] buf = new byte[req.getContentLength()];
//        is.read(buf);
//
//		Message msg = Message.fromJSON(new String(buf));

        //Message msg = Message.deserialize(req.getInputStream());




		Message msg = Message.fromJSON(IOUtils.toString(req.getInputStream(), "UTF-8"));


		if (msg != null) {
            msgList.add(msg);
            resp.setStatus(200);
        } else {
            resp.setStatus(400); // Bad request
        }
	}
}
