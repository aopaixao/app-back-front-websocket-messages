import { Client } from "@stomp/stompjs";
import React, { useCallback, useEffect, useState } from "react";

const useStompClientComp = () => {
  let stompClient = null;
  let subscriptions = {};

  const connectAndSubscribe = (path, callback) => {
    console.log(`stompClient: ${JSON.stringify(stompClient)}`);
    if (!stompClient) {
      console.log('Initialize stomp client...');
      const stompConfig = {
        connectHeaders: {},
        brokerURL: import.meta.env.VITE_WEBSOCKET_URL,
        debug: function (str) {
          console.log('STOMP: ' + str);
        },
        reconnectDelay: import.meta.env.VITE_WEBSOCKET_RECONNECT_DELAY,
      };

      stompClient = new Client(stompConfig);
      //setStompClient(new Client(stompConfig));
      stompClient.activate();
      console.log(`stompClient after activate: ${JSON.stringify(stompClient)}`);
    }

    stompClient.onConnect = () => {
      console.log('Stomp client connected...');
      subscribe(path, callback);
    };
  }

  const subscribe = (path, callback) => {
    console.log(`subscriptions on subscribe: ${JSON.stringify(subscriptions)}`);
    if (subscriptions[path]) return;

    const subscription = stompClient.subscribe(path, (message) => {
      const body = JSON.parse(message.body);
      //console.log('Resultado: ' + JSON.stringify(body));
      callback(body);
    });

    subscriptions[path] = subscription;
  }

  return {connectAndSubscribe};

}

export default useStompClientComp;