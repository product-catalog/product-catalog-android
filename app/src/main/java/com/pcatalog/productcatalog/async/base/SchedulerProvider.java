package com.pcatalog.productcatalog.async.base;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public interface SchedulerProvider {
    Scheduler background();
    Scheduler ui();
}
