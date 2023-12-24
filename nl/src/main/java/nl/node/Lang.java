package nl.node;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Lang {
    private OutputStream out;
    private InputStream in;

    private PrintStream printStream;

    private boolean debug = false;

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


    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isDebug() {
        return debug;
    }


    public PrintStream printStream(){
        if(printStream!=null) return printStream;
        printStream = new PrintStream(out);
        return printStream;
    }

    public OutputStream getOut() {
        return out;
    }

    public InputStream getIn() {
        return in;
    }
}
