package blogspot.devcleannotes.reactivelogtailer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.input.TailerListenerAdapter;
import org.springframework.stereotype.Component;
import rx.subjects.PublishSubject;

@Slf4j
@Component
public class LogTailerListener extends TailerListenerAdapter {


    final PublishSubject<String> logPublishSubject = PublishSubject.create();

    @Override
    public void handle(String line) {
        logPublishSubject.onNext(line);
    }
}
