import React, { useEffect, useState } from "react";
import Axios from 'axios';
import NavBar from "../NavBar/NavBar";
import { Typography, Container, Box, Card, CardContent } from '@mui/material';
import Perfil from "../Images/807c7f9e099d212944e50f0d7e1ec78706271a4f_full.jpg";

const MostrarPerfilEstudiante = () => {
  const [estudiante, setEstudiante] = useState({});

  useEffect(() => {
    const obtenerEstudiante = async () => {
      try {
        const response = await Axios.get("http://localhost:8090/estudiantes/ByCarrera/1");
        setEstudiante(response.data);
      } catch (error) {
        console.error("Error al obtener el estudiante:", error);
      }
    };

    obtenerEstudiante();
  }, []);

  return (
    <Container>
      <NavBar />
      <Box mt={3} display="flex" justifyContent="center" alignItems="center" flexDirection="column">
        <Typography variant="h5" gutterBottom>
          Mostrar Perfil de Estudiante
        </Typography>
        {estudiante && (
          <Card style={{ width: "200px", borderRadius: "12px", boxShadow: "0px 4px 8px rgba(0, 0, 0, 0.1)"}}>
            {/* Agregar la imagen */}
            <img src={Perfil} alt="Foto de perfil" style={{ width: "100%", height: "auto", borderTopLeftRadius: "12px", borderTopRightRadius: "12px" }} />
            <CardContent style={{ padding: "16px" }}>
              <Typography style={{ marginBottom: "8px"}}>
                Nombre: {estudiante.nombres} 
              </Typography>
              <Typography>
                Apellidos: {estudiante.apellidos}
              </Typography>
              <Typography style={{ marginTop: "8px" }}>
                Rut: {estudiante.rut}
              </Typography>
              <Typography>
                Email: {estudiante.email}
              </Typography>
            </CardContent>
          </Card>
        )}
        {!estudiante && <p>No se encontró información del estudiante.</p>}
      </Box>
    </Container>
  );
};

export default MostrarPerfilEstudiante;

