# Minecraft Player Verification
[![CI](https://github.com/TheShireMinecraft/minecraft-player-verification/actions/workflows/_ci_master_build_and_test.yml/badge.svg?branch=master)](https://github.com/TheShireMinecraft/minecraft-player-verification/actions/workflows/_ci_master_build_and_test.yml)
[![codecov](https://codecov.io/gh/TheShireMinecraft/minecraft-player-verification/branch/master/graph/badge.svg?token=T18NMVNX5L)](https://codecov.io/gh/TheShireMinecraft/minecraft-player-verification)

## Overview
Generates time-limited signed tokens players may use to verify ownership of their Minecraft account. For example, to link their in-game account to a website account.

## Configuration
- `verificationBaseUrl` - The base URL of the verification endpoint you want to link to, which should typically include a trailing slash.
- `tokenSigningKey` - The 32 character key with which to sign the token.
- `tokenExpiryInMinutes` - Token lifetime in minutes, remember to account for systems potentially being a minute or so out of sync.
- `replaceJwtDotsWithSlashes` - Replace dots with slashes in the generated token, which might make it slightly easier to parse at the website end.
- `omitJwtHeaderFromUrl` - Omit the JWT header in the URL, because it is the same for each request, resulting in shorter links. The server-side can prepend the header if the details are known at both ends.
- `omitJwtHeaderAndPayloadEyjPrefix` - A minor optimisation to strip the first 3 characters from the header and payload, the server can add this back in.
