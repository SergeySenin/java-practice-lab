package org.study.javarush.java.core.level14.tasks14.g;

public class ManagedServer {

    private String  serverName;
    private int     cpuCoreCount;
    private boolean online;
    private int     restartCount;

    public ManagedServer(String serverName, int cpuCoreCount) {
        this.serverName = serverName;
        this.cpuCoreCount = cpuCoreCount;
    }

    public ManagedServer(String serverName) {
        this(serverName, 2);
    }

    public ManagedServer() {
        this("unassigned-server");
    }


    public String getServerName() {
        return serverName;
    }

    public int getCpuCoreCount() {
        return cpuCoreCount;
    }

    public boolean isOnline() {
        return online;
    }

    public int getRestartCount() {
        return restartCount;
    }

    public void startServer() {
        online = true;
    }

    public void stopServer() {
        online = false;
    }

    public boolean restartServer() {
        if (!online) {
            return false;
        }

        restartCount++;
        return true;
    }

    public void renameServer(String serverName) {
        this.serverName = serverName;
    }

    public void printInfo() {
        System.out.println(
                "Server: "        + serverName
                + ", CPU cores: " + cpuCoreCount
                + ", online: "    + online
                + ", restarts: "  + restartCount
        );
    }
}
