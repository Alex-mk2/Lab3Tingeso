import React, { useState } from "react";
import Axios from 'axios';
import NavBar from "../NavBar/NavBar";
import Swal from 'sweetalert2';
import { Typography, TextField, Button, Container, Box } from '@mui/material';

const IngresoEstudiante = () => {
  const [nuevoEstudiante, setNuevoEstudiante] = useState({
    codigoCarrera: '',
    rut: '',
    nombres: '',
    apellidos: '',
    email: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNuevoEstudiante({ ...nuevoEstudiante, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await Axios.post("http://localhost:8090/estudiantes", nuevoEstudiante);

      setNuevoEstudiante({
        codigoCarrera: '',
        rut: '',
        nombres: '',
        apellidos: '',
        email: '',
      });

      Swal.fire("Éxito", "Estudiante creado con éxito", "success");
    } catch (error) {
      console.error("Error al agregar el estudiante:", error);
      Swal.fire("Fallido", "Error al agregar el estudiante", "error");
    }
  };

  return (
    <Container>
      <NavBar />
      <Box mt={3}>
        <Typography variant="h5" gutterBottom>
          Agregar estudiante
        </Typography>
        <form onSubmit={handleSubmit}>
          {/* Agregar campos del formulario */}
          <TextField
            label="Código carrera"
            name="codigoCarrera"
            value={nuevoEstudiante.codigoCarrera}
            onChange={handleInputChange}
            required
          />
          {/* Otros campos del formulario */}
          <TextField
            label="Rut"
            name="rut"
            value={nuevoEstudiante.rut}
            onChange={handleInputChange}
            required
          />
          <TextField
            label="Nombres"
            name="nombres"
            value={nuevoEstudiante.nombres}
            onChange={handleInputChange}
          />
          <TextField
            label="Apellidos"
            name="apellidos"
            value={nuevoEstudiante.apellidos}
            onChange={handleInputChange}
            required
          />
          <TextField
            label="Email"
            name="email"
            value={nuevoEstudiante.email}
            onChange={handleInputChange}
            required
          />
          <Button type="submit" variant="contained" color="primary">
            Agregar Estudiante
          </Button>
        </form>
      </Box>
    </Container>
  );
};

export default IngresoEstudiante;
