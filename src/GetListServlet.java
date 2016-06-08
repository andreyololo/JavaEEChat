
import Client.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetListServlet extends HttpServlet {
	
	private MessageList msgList = MessageList.getInstance();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException 
	{
		String fromStr = req.getParameter("from");
		int from = Integer.parseInt(fromStr);
		
//		String json = msgList.toJSON(from);
//		if (json != null) {
//			OutputStream os = resp.getOutputStream();
//			os.write(json.getBytes());
//		}

		String stringMessages = msgList.toJSON(from);
        if (stringMessages != null) {
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.write(stringMessages);
            printWriter.flush();
            printWriter.close();
        }

//        ArrayList<Message> messages = msgList.serialize(from);
//
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(resp.getOutputStream());
//            objectOutputStream.writeObject(messages);
//            objectOutputStream.flush();
//            objectOutputStream.close();

	}
}
