import { useState, useEffect } from 'react'
import useStompClientComp from './components/StompClientComp';

const App = () => {
  const [messages, setMessages] = useState([]);
  const {connectAndSubscribe} = useStompClientComp();

  const getMessages = (body) => {
    const content = JSON.parse(JSON.stringify(body));
    //console.log(`content: ${JSON.stringify(content)}`);

   setMessages(prevMessages => prevMessages.concat(content));
  }

  useEffect(() => {
    connectAndSubscribe('/b2c/messages', getMessages);
  }, []);

  return (
    <>
      <div className="card">
        <h1>Notificações Push</h1>
        <p className="read-the-docs">
          App para Exibição de Notificações Push Provenientes do Backend Websocket com Spring Boot
        </p>
        <ul>
          {messages.map((message, i) => (
            <li key={i}>
              {
              `Id: ${message.idPromocao} - Nome: ${message.nomePromocao} - Descrição: ${message.descricaoPromocao}`
              }</li>
          ))}
        </ul>
      </div>
    </>
  )
}

export default App;