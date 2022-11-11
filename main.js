const { app, ipcMain, BrowserWindow } = require("electron");

//DRCP
const clientId = '1033060598914764841';
const DiscordRPC = require('discord-rpc');

let appWin;

createWindow = () => {
    appWin = new BrowserWindow({
        width: 800,
        height: 600,
        title: "Angular and Electron",
        resizable: true,
        webPreferences: {
            contextIsolation: false,
            nodeIntegration: true
        }
    });

    appWin.loadURL(`file://${__dirname}/dist/index.html`);

    appWin.setMenu(null);

    appWin.webContents.openDevTools();

    appWin.on("closed", () => {
        appWin = null;
    });
}

app.on("ready", createWindow);

app.on("window-all-closed", () => {
    if (process.platform !== "darwin") {
      app.quit();
    }
});

//Para mete discordRCP luego
ipcMain.on("DiscordInfo", (event) => event.reply("reply", "pong"));

//DiscordRCP
DiscordRPC.register(clientId);
const rpc = new DiscordRPC.Client({ transport: 'ipc' });
const startTimestamp = new Date();
async function setActivity() {
  rpc.setActivity({
    details: `Usando la mejor app de peliculas`,
    state: 'Mirando The Avengers',
    startTimestamp,
    largeImageKey: 'kprojectlogobluewithout',
    largeImageText: 'Usa Kūhaku!',
    smallImageKey: 'mchearth',
    smallImageText: 'La Mejor',
    instance: false,
    buttons: [{ label: 'Kūhaku', url: 'https://www.youtube.com/watch?v=dQw4w9WgXcQ' },],
  });
}

rpc.on('ready', () => {
  setActivity();
  setInterval(() => {
    setActivity();
  }, 15e3);
});
rpc.login({ clientId }).catch(console.error);
