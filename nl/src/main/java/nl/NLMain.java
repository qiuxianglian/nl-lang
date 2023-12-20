/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package nl;



import java.io.*;
import java.util.HashMap;
import java.util.Map;

public final class NLMain {

    public static final String NL = "nl";


    /**
     * The main entry point.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader source;
        Map<String, String> options = new HashMap<>();
        String file = null;
        boolean launcherOutput = true;
        for (String arg : args) {
            if (file == null) {
                file = arg;
            }
        }

        if (file == null) {
            // @formatter:off
            source =  new InputStreamReader(System.in);
            // @formatter:on
        } else {
            source =  new InputStreamReader(new FileInputStream(file));
        }

        System.exit(executeSource(source, System.in, System.out, options, launcherOutput));
    }

    private static int executeSource(InputStreamReader source, InputStream in, PrintStream out, Map<String, String> options, boolean launcherOutput) {
        PrintStream err = System.err;
        NLLang nlLang;
        try {
            nlLang = new NLLang();
            Object result = nlLang.eval(source);

            if (result!=null) {
                out.println(result);
            }
            return 0;
        } catch (NLException ex) {
            if (ex.isInternalError()) {
                // for internal errors we print the full stack trace
                ex.printStackTrace();
            } else {
                err.println(ex.getMessage());
            }
            return 1;
        } finally {
        }
    }


}
