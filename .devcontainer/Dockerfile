FROM mcr.microsoft.com/devcontainers/java:1-11-bookworm

RUN apt-get update \
    && apt-get install -y chromium chromium-driver \
    && rm -rf /var/lib/apt/lists/*
