#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_34b3688be8a5_key -iv $encrypted_34b3688be8a5_iv -in travis/codesigning.asc.enc -out travis/codesigning.asc -d

    gpg --fast-import travis/codesigning.asc
fi
