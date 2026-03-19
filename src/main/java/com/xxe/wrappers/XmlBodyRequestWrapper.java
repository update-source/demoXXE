package com.xxe.wrappers;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class XmlBodyRequestWrapper extends HttpServletRequestWrapper {
  private final byte[] sanitizedBody;

  public XmlBodyRequestWrapper(HttpServletRequest request) throws IOException {
    super(request);
    byte[] rawBody = request.getInputStream().readAllBytes();
    String bodyStr = new String(rawBody, StandardCharsets.UTF_8);

    String cleanedStr = bodyStr.replace("\uFEFF", "").trim();
    
    this.sanitizedBody = cleanedStr.getBytes(StandardCharsets.UTF_8);
  }

  /** 
   * @return ServletInputStream
   */
  @Override
  public ServletInputStream getInputStream() {
    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sanitizedBody);
    return new ServletInputStream() {
        @Override
        public int read() { return byteArrayInputStream.read(); }
        @Override
        public boolean isFinished() { return byteArrayInputStream.available() == 0; }
        @Override
        public boolean isReady() { return true; }
        @Override
        public void setReadListener(ReadListener readListener) {}
    };
  }

  /** 
   * @return BufferedReader
   */
  @Override
  public BufferedReader getReader() {
      return new BufferedReader(new InputStreamReader(this.getInputStream(), StandardCharsets.UTF_8));
  }
}