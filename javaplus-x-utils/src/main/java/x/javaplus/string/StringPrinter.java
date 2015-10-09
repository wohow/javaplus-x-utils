package x.javaplus.string;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringPrinter {

	private StringWriter sw = new StringWriter();
	private PrintWriter out = new PrintWriter(sw);

	public StringPrinter(String text) {
		print(text);
	}

	public StringPrinter() {
	}

	public void print(Object x) {
		out.print(x);
	}

	public void println(Object x) {
		out.println(x);
	}

	@Override
	public String toString() {
		return sw.toString();
	}

	public void replaceAll(String regex, String replacement) {
		String string = sw.toString();
		String rp = string.replaceAll(regex, replacement);
		sw = new StringWriter();
		out = new PrintWriter(sw);
		out.print(rp);
	}
}
