/**
 * @reference https://www.youtube.com/watch?v=9ErAONqE6HE
 */
const EventEmitter = require("events");
const eventEmitter = new EventEmitter();
eventEmitter.on("messageEmitter", function (data) {
  console.log("messageEmitter", data);
});

eventEmitter.emit("messageEmitter", { isSuccess: true, message: "Message emitter" });
