package nl.node;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Lang {
    private OutputStream out;
    private InputStream in;

    public Lang() {
        out = System.out;
        in = System.in;
    }

    public Lang setOut(OutputStream out) {
        this.out = out;
        return this;
    }

    public Lang setIn(InputStream in) {
        this.in = in;
        return this;
    }

    public PrintStream printStream(){
        return new PrintStream(out);
    }

    public OutputStream getOut() {
        return out;
    }

    public InputStream getIn() {
        return in;
    }
}
