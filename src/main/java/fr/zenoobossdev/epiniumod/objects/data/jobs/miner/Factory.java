package fr.zenoobossdev.epiniumod.objects.data.jobs.miner;

import fr.zenoobossdev.epiniumod.util.interfaces.IJobMiner;

import java.util.concurrent.Callable;

public class Factory implements Callable<IJobMiner> {

    @Override
    public IJobMiner call() throws Exception {
        return new JobMinerHolder();
    }
}