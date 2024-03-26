import './App.css';
import Login from './Login';


function App() {
  return (
    <div className="App">
      <header className="App-header">
          <Login /> {/* Renderiza el componente de inicio de sesión */}

      </header>
    </div>
  );
}

export default App;
//java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:../db/mydb --dbname.0 xdb
//comando para startear la db
