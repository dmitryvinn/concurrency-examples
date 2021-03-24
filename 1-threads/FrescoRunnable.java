//@link https://frescolib.org/docs/datasources-datasubscribers.html

public class FrescoRunnable extends Activity {
    
    BaseAdapter adapter = ... // Uses Fresco images to populate the UI
    private void demoThread() {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Refreshes UI
                    adapter.notifyDataSetChanged();
                }
            });
        } catch (Exception e) {
            // error
        }
    }
}
