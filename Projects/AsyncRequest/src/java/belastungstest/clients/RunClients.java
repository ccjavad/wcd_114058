package belastungstest.clients;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
    Achtung! Das ist nur ein sehr grober Test.

----------------------------
-------  Test: sync
------- CLIENTS: 2
Zeit: 2104 Millis.
Zeit: 2.104 Sek.
----------------------------
-------  Test: ASYNC
------- CLIENTS: 2
Zeit: 2118 Millis.
Zeit: 2.118 Sek.


----------------------------
-------  Test: sync
------- CLIENTS: 50
Zeit: 2269 Millis.
Zeit: 2.269 Sek.
----------------------------
-------  Test: ASYNC
------- CLIENTS: 50
Zeit: 2516 Millis.
Zeit: 2.516 Sek.


----------------------------
-------  Test: sync
------- CLIENTS: 100
Zeit: 2687 Millis.
Zeit: 2.687 Sek.

----------------------------
-------  Test: sync
------- CLIENTS: 200
Zeit: 2693 Millis.
Zeit: 2.693 Sek.

----------------------------
-------  Test: sync
------- CLIENTS: 400
Zeit: 7295 Millis.
Zeit: 7.295 Sek.

----------------------------
-------  Test: sync
------- CLIENTS: 650
Zeit: 14064 Millis.
Zeit: 14.064 Sek.

----------------------------
-------  Test: sync
------- CLIENTS: 1000
Zeit: 20596 Millis.
Zeit: 20.596 Sek.

----------------------------
-------  Test: sync
------- CLIENTS: 2000
Zeit: 45040 Millis.
Zeit: 45.04 Sek.
*/
public class RunClients {

//    private static final String URL_NAME = "http://localhost:8084/AsyncRequest/sync";
    private static final String URL_NAME = "http://localhost:8084/AsyncRequest/async";
    private static final int CLIENTS = 50;
    
    public static void main(String[] args) throws InterruptedException {
        
        List<Thread> clientThreads = new ArrayList<>();
        
        for (int i = 0; i < CLIENTS; i++) {
            clientThreads.add(new ClientThread());
        }
        
        long testStart = System.currentTimeMillis();
        
        for (Thread ct : clientThreads) {
            ct.start();
        }
        
        for (Thread ct : clientThreads) {
            ct.join();
        }
        
        long testEnd = System.currentTimeMillis();
        
        System.out.println("----------------------------");
        if(URL_NAME.endsWith("async")) {
            System.out.println("-------  Test: ASYNC");
        } else {
            System.out.println("-------  Test: sync");
        }
        System.out.println("------- CLIENTS: " + CLIENTS);
        System.out.println("Zeit: " + (testEnd - testStart) + " Millis.");
        System.out.println("Zeit: " + (testEnd - testStart)/1000. + " Sek.");
    }
    
    //----------------------------------------------
    static class ClientThread extends Thread {
        @Override
        public void run() {
            try {
                URL url = new URL(URL_NAME);
                try( BufferedReader in = new BufferedReader(new InputStreamReader( url.openStream() )) ) {
                    
                    String line;
                    while( (line = in.readLine()) != null ) {
//                        System.out.println(line);
                    }
                }
            
            } catch(Exception e) {
                System.out.println("### Fehler: " + e.getMessage());
            }
        }
    }
}
