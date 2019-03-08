package blogspot.devcleannotes.reactivelogtailer.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.input.Tailer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;

@Service
@RequiredArgsConstructor
public class ReactiveLogTailerService {

    @Value("${logging.file}")
    private String logFileName;
    private Tailer logTailer;

    private final LogTailerListener logTailerListener;

    @PostConstruct
    public void init() {
        File logFile = new File(logFileName);
        logTailer = Tailer.create(logFile, logTailerListener, 3000L);
        // subsribe to channel
        logTailerListener.logPublishSubject.subscribe();
    }


    public void getLogTail() {
        logTailer.run();
    }





}
