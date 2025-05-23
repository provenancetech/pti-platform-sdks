# Official PTI TypeScript SDK
For detailed API documentation please refer to the [PTI API Reference](TBD).

Building the API client library requires:

- Node.js 16+
- Yarn 1.22+ or NPM 6.14+


## Installation

### Published Package
If you're not already logged in to the GitHub npm registry, you'll be prompted for your GitHub 
username and a password — which is actually a personal access token with `read:write:delete repository` scopes.
``` shell
npm login --registry=https://npm.pkg.github.com
```
To publish the generated package to the GitHub npm registry, use the following command:
``` shell
yarn publish --access public
```
This command will prompt you to enter the new SDK version number, so there's no need to update package.json manually beforehand.


### Locally
To use the TypeScript SDK locally using Yarn or Npm, the simplest method is to create a 
link from this current repository and use this link in your projects.

First, open a terminal in this directory `pti-platform-sdks/ts` and create a link using
```shell
yarn link
```


A link will be created with the package name `pti-ts-sdk`.

To use this link in your projects, navigate to your project directory and reuse the link command with the package name:

```shell
cd <your-project-directory>
yarn link "@provenancetech/pti-ts-sdk"
```


The package will be added as a module to the `<your-project-directory>/node_modules/pti-ts-sdk` directory.
You will now be able to import desired PTI resources from this module in your projects.


## Getting Started
### Initialize PTI Client
You can either pass the path to your private key or directly the private key value. \
You can initialize the PTI SDK by providing the parameters directly:

#### Typescript
```typescript
import { PTIClient, PTIEnvironment } from "pti-ts-sdk";

const ptiClient = new PTIClient({
    environment: PTIEnvironment.STAGING,
    ptiClientId: "<client ID provided by PTI>",
    privateKeyPath: "<path to your private key>",
    privateKey: "<private key>",
});
```
