package com.niit.massage;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class Massage
{
	public Massage(String phone,String Text) throws Exception
	{
		HttpClient client=new HttpClient();
		PostMethod post=new PostMethod("http://gbk.sms.webchinese.cn");
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data={new NameValuePair("Uid", "youngenjoy"),new NameValuePair("Key", "b163f89588e52cb97fd8"),
								new NameValuePair("smsMob",phone),new NameValuePair("smsText",Text)};
		post.setRequestBody(data);
		client.executeMethod(post);
		Header[] headers=post.getResponseHeaders();
		int statusCode=post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		
		
		for(Header h:headers)
		{
			System.out.println(h.toString());
		}
		String result=new String(post.getResponseBodyAsString().getBytes("gbk"));
		System.out.println(result);
		post.releaseConnection();
	}
}
