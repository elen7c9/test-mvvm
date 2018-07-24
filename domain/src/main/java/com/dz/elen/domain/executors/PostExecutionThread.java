package com.dz.elen.domain.executors;

import io.reactivex.Scheduler;

public interface PostExecutionThread  {
    Scheduler getScheduler();
}
