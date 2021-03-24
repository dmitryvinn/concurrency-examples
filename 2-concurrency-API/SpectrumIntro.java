public class SpectrumIntro extends Application {
    private Spectrum mSpectrum;

    @Override
    public void onCreate() {
        super.onCreate();
        // 1. Initialize Loader
        SpectrumSoLoader.init(this);

        // 2. Specify plugins
        mSpectrum = Spectrum.make(new SpectrumLogcatLogger(Log.INFO), DefaultPlugins.get()); 
    }

    // 3. Using Spectrum
    private SpectrumResult transcodeFile(...) {
        return mSpectrum.transcode(
            EncodedImageSource.from(inputFile),
            EncodedImageSink.from(outputStream),
            TranscodeOptions.Builder(new EncodeRequirement(JPEG, 80)).build(),
            "my_callsite_identifier");
    }

    // 4. Apply Concurrency API
    ConcurrentHashMap<String, SpectrumResult> transcodedImages = new ConcurrentHashMap<>(CAPACITY, DENSITY, NUMBER_OF_THREADS);
    private void processDuplicateImages(...) {
        transcodedImages.putIfAbsent(fileName, transcodeFile);
    }

    

}