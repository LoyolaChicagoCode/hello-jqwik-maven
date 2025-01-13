package hw;

public class HelloWorld {

  public String getMessage() {
    return "hello world";
  }

  public int getYear() {
    return 2025;
  }

  public String echo(final String msg) {
    return msg;
  }

  public String echoTwice(final String msg) {
    return msg + " " + msg;
  }
}
