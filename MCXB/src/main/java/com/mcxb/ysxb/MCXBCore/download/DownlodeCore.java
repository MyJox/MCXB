package com.mcxb.ysxb.MCXBCore.download;

import org.to2mbn.jmccc.mcdownloader.MinecraftDownloader;
import org.to2mbn.jmccc.mcdownloader.MinecraftDownloaderBuilder;
import org.to2mbn.jmccc.mcdownloader.download.concurrent.CallbackAdapter;
import org.to2mbn.jmccc.mcdownloader.download.concurrent.DownloadCallback;
import org.to2mbn.jmccc.mcdownloader.download.tasks.DownloadTask;
import org.to2mbn.jmccc.option.MinecraftDirectory;
import org.to2mbn.jmccc.version.Version;

import java.io.File;

public class DownlodeCore {
    private String minecraftV = "";

    public void CoreDownload() {
        File folder = new File(".minecraft");
        if (!folder.exists() && !folder.isDirectory()) {
            folder.isFile();
        } else {
            System.out.println("The folder already exists");
        }
        System.out.println("Folder. minecraft created successfully");
        MinecraftDirectory dir = new MinecraftDirectory(".minecraft");
        MinecraftDownloader downloader = MinecraftDownloaderBuilder.buildDefault();
        downloader.downloadIncrementally(dir, minecraftV, new CallbackAdapter<>() {

            @Override
            public void failed(Throwable err) {
                // Call on failure
                System.out.printf("-------------- HCXB --------------\n" + "Call on failure" + err + "\n-------------- HCXB --------------");
                err.printStackTrace(System.err);
            }

            @Override
            public void done(Version result) {
                // Call upon completion
                System.out.printf("-------------- HCXB --------------\n" + "Download completed, downloaded Minecraft version: %s%n", result + "\n-------------- HCXB --------------");
            }

            @Override
            public void cancelled() {
                // Called when cancelled
                System.out.print("Download canceled%s%n");
            }

            @Override
            public <R>DownloadCallback<R> taskStart(DownloadTask<R> task) {
                // Called when a download task is spawned
                // Return a DownloadCallback here to listen to the status of the download task
                System.out.printf("Start downloading: %s%n", task.getURI());
                return new CallbackAdapter<R>() {

                    @Override
                    public void done(R result) {
                        // Call when this DownloadTask is completed
                        System.out.printf("Subtask completed: %s%n", task.getURI());
                    }

                    @Override
                    public void failed(Throwable e) {
                        // Call when this DownloadTask fails
                        System.out.printf("Subtask failed: %s。reason: %s%n", task.getURI(), e);
                    }

                    @Override
                    public void cancelled() {
                        // Called when this DownloadTask is cancelled
                        System.out.printf("Subtask cancellation: %s%n", task.getURI());
                    }
                };
            }
        });
    }

    public String getMinecraftV() {
        return minecraftV;
    }

    public void setMinecraftV(String minecraftV) {
        this.minecraftV = minecraftV;
    }

}
