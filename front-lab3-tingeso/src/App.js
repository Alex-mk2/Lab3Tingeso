import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Inicio from "./components/Inicio/inicio";
import IngresoHorario from "./components/IngresoHorarios/ingresoHorarios";
import MostrarHorario from "./components/mostrarHorariosBloque/mostrarHorarios";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" Component={Inicio} />
        <Route path="/ingresoHorarios" Component={IngresoHorario}></Route>
        <Route path="/mostrarHorarios" Component={MostrarHorario}></Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
