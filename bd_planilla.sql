-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2021 a las 00:36:42
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_planilla`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `dui` varchar(12) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `fecha_contratacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `nombre`, `dui`, `cargo`, `direccion`, `telefono`, `fecha_contratacion`) VALUES
(1, 'rey', '878754', 'contador', 'dwdwdwedwfwf', '789-878', '2021-06-15'),
(2, 'carlos', '6331', 'sastre', 'su casa', '8661-5454', '2021-06-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `infopago`
--

CREATE TABLE `infopago` (
  `id` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `unidades` int(11) NOT NULL,
  `descuento` double NOT NULL,
  `total_dia` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `infopago`
--

INSERT INTO `infopago` (`id`, `id_empleado`, `fecha`, `unidades`, `descuento`, `total_dia`) VALUES
(1, 1, '2021-06-15', 20, 0, 8),
(2, 1, '2021-06-16', 15, 1, 7),
(4, 1, '2021-06-16', 15, 1, 7),
(5, 1, '2021-06-16', 29, 0, 10),
(6, 1, '2021-06-16', 30, 0, 10),
(7, 1, '2021-06-16', 1, 5, 3),
(8, 1, '2021-06-16', 20, 0, 8),
(9, 1, '2021-06-16', 15, 1.25, 6.75),
(10, 2, '2021-06-17', 15, 1.25, 6.75),
(11, 2, '2021-06-17', 20, 0, 8),
(12, 2, '2021-06-19', 30, 0, 10),
(13, 2, '2021-06-30', 15, 1.25, 6.75);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagoempleados`
--

CREATE TABLE `pagoempleados` (
  `id_pago` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `salario_base` double NOT NULL,
  `isss` double NOT NULL,
  `afp` double NOT NULL,
  `descuento` double DEFAULT NULL,
  `fecha_pago` date NOT NULL,
  `salario_total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pagoempleados`
--

INSERT INTO `pagoempleados` (`id_pago`, `id_empleado`, `salario_base`, `isss`, `afp`, `descuento`, `fecha_pago`, `salario_total`) VALUES
(2, 2, 31.5, 0.95, 2.28, 0, '2021-06-30', 28.27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `rol` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id_rol` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `infopago`
--
ALTER TABLE `infopago`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `pagoempleados`
--
ALTER TABLE `pagoempleados`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `usuario_ibfk_1` (`id_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `infopago`
--
ALTER TABLE `infopago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `pagoempleados`
--
ALTER TABLE `pagoempleados`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
