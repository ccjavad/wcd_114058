package async_listener;

import java.io.IOException;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class MyAsyncListener implements AsyncListener {

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("--> onStartAsync. Listener: " + this.hashCode());
    }
    
    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("--> onComplete. Listener: " + this.hashCode());
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
    }

}
