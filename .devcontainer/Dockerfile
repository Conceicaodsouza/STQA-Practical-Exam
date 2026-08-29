FROM mcr.microsoft.com/devcontainers/java:11-bookworm

USER root

RUN apt-get update \
    && apt-get install -y chromium chromium-driver \
    && rm -rf /var/lib/apt/lists/*

USER vscode
