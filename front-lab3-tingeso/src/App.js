import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Inicio from "./components/Inicio/inicio";
import IngresoHorario from "./components/IngresoHorarios/ingresoHorarios";
import MostrarHorario from "./components/mostrarHorariosBloque/mostrarHorarios";
import PerfilEstudiante from "./components/perfilEstudiante/perfilEstudiante";
import IngresoEstudiante from "./components/ingresoEstudiante/ingresoEstudiante";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" Component={Inicio} />
        <Route path="/ingresoHorarios" Component={IngresoHorario}></Route>
        <Route path="/mostrarHorarios" Component={MostrarHorario}></Route>
        <Route path="/perfilEstudiante" Component={PerfilEstudiante}></Route>
        <Route path="/ingresoEstudiante" Component={IngresoEstudiante}></Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
