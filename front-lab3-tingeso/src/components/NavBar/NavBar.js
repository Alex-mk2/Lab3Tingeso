import React from 'react';
import { Link } from 'react-router-dom';

const NavBar = () => {
  return (
    <nav style={styles.navBar}>
      <div style={styles.logoContainer}>
        <span style={styles.logoText}>Loa 2.0</span>
      </div>
      {/* Agregamos la sección de elementos de navegación */}
      <ul style={styles.navItems}>
        <li style={styles.navigationItem}>
          <Link to="/" style={styles.link}>
            Inicio
          </Link>
        </li>
        {/* Agrega más elementos de navegación según sea necesario */}
      </ul>
    </nav>
  );
};

const styles = {
  navBar: {
    backgroundColor: '#2c3e50', // Cambiado a un tono más oscuro
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '10px 20px', // Aumentamos el espacio interno
    color: '#ecf0f1', // Cambiado a un tono más claro
    boxShadow: '0px 2px 5px rgba(0, 0, 0, 0.2)',
    borderRadius: '8px',  // Agregamos esquinas redondeadas
  },
  logoContainer: {
    display: 'flex',
    alignItems: 'center',
  },
  logoText: {
    fontSize: '24px',
    fontWeight: 'bold',
    marginLeft: '10px',
  },
  navItems: {
    display: 'flex',
    listStyle: 'none',
    margin: 0,
    padding: 0,
  },
  navigationItem: {
    margin: '0 15px',
  },
  link: {
    color: '#ecf0f1',
    textDecoration: 'none',
    padding: '10px 15px', // Aumentamos el espacio interno
    borderRadius: '5px',
    transition: 'background-color 0.3s ease',
  },
  linkHover: {
    backgroundColor: '#34495e', // Cambiado a un tono más oscuro al hacer hover
  },
};

export { NavBar as default, styles };
