-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 12-Jul-2019 às 02:25
-- Versão do servidor: 10.1.39-MariaDB
-- versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `Atendente`
--

CREATE TABLE `Atendente` (
  `id` int(11) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `tipoSanguineo` varchar(255) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Atendente`
--

INSERT INTO `Atendente` (`id`, `cpf`, `dataNascimento`, `nome`, `sexo`, `telefone`, `tipoSanguineo`, `idEndereco`, `idUsuario`) VALUES
(268, '186.402.484-32', '2019-07-11', 'Shaeleigh Leonard', 'MASCULINO', '48990323', 'O+', 269, 270),
(333, '086.402.199-23', '2019-07-31', 'Henrique Lemes', 'MASCULINO', '', 'O+', 334, 335);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Consulta`
--

CREATE TABLE `Consulta` (
  `id` int(11) NOT NULL,
  `dataAgendamento` datetime NOT NULL,
  `diagnostico` varchar(255) DEFAULT NULL,
  `realizada` bit(1) NOT NULL,
  `idAtendente` int(11) NOT NULL,
  `idEspecialidade` int(11) DEFAULT NULL,
  `idMedico` int(11) DEFAULT NULL,
  `idOcupacaoSala` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Consulta`
--

INSERT INTO `Consulta` (`id`, `dataAgendamento`, `diagnostico`, `realizada`, `idAtendente`, `idEspecialidade`, `idMedico`, `idOcupacaoSala`, `idPaciente`) VALUES
(271, '2019-07-11 19:22:39', NULL, b'0', 268, 8, 14, 272, 212),
(273, '2019-07-11 19:22:53', NULL, b'0', 268, 1, 14, 274, 216),
(275, '2019-07-11 19:23:24', '', b'1', 268, 1, 14, 276, 216),
(277, '2019-07-11 19:27:15', NULL, b'0', 268, 1, 14, 278, 168),
(279, '2019-07-11 19:27:51', NULL, b'0', 268, 1, 14, 280, 164),
(302, '2019-07-11 19:43:37', NULL, b'0', 268, 1, 14, 303, 236),
(304, '2019-07-11 19:43:50', NULL, b'0', 268, 1, 14, 305, 228);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Doenca`
--

CREATE TABLE `Doenca` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `doenca_paciente`
--

CREATE TABLE `doenca_paciente` (
  `idPaciente` int(11) NOT NULL,
  `idDoenca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Endereco`
--

CREATE TABLE `Endereco` (
  `id` int(11) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(9) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `localidade` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Endereco`
--

INSERT INTO `Endereco` (`id`, `bairro`, `cep`, `complemento`, `localidade`, `logradouro`, `numero`, `uf`) VALUES
(15, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(18, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(21, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(24, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(27, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(30, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(33, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(36, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(42, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(45, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(48, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(51, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(54, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(57, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(60, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(63, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(66, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(72, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(75, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(78, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(81, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(84, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(87, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(90, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', '', 'SC'),
(93, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(96, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(99, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(102, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(135, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(138, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(141, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(144, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(147, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', '', 'SC'),
(150, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(153, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(156, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(159, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(162, 'RioGrande', '88131-743', '48', 'Palhoça', 'Braulina Goulart', NULL, 'SC'),
(165, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(169, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(173, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(177, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(181, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(185, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(189, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(193, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', '', 'SC'),
(197, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(201, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(205, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(209, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(213, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(217, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(221, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(225, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(229, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(233, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(237, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(241, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(269, 'RioGrande', '88131-743', '48', '', 'Braulina Goulart', NULL, 'SC'),
(328, 'Rio Grande', '88131-743', '', 'Palhoça', 'Rua Braulina Goulart', '', 'SC'),
(331, 'Rio Grande', '88131-743', '', 'Palhoça', 'Rua Braulina Goulart', '', 'SC'),
(334, 'Rio Grande', '88131-743', '', 'Palhoça', 'Rua Braulina Goulart', '', 'SC');

-- --------------------------------------------------------

--
-- Estrutura da tabela `Enfermeiro`
--

CREATE TABLE `Enfermeiro` (
  `id` int(11) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `tipoSanguineo` varchar(255) NOT NULL,
  `corenCofen` varchar(255) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `idEspecialidade` int(11) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Enfermeiro`
--

INSERT INTO `Enfermeiro` (`id`, `cpf`, `dataNascimento`, `nome`, `sexo`, `telefone`, `tipoSanguineo`, `corenCofen`, `idEndereco`, `idEspecialidade`, `idUsuario`) VALUES
(74, '186.402.484-20', '2019-07-11', 'Hilary Roach', 'MASCULINO', '48996850323', 'O+', '1234560', 75, 1, 76),
(77, '186.402.484-21', '2019-07-11', 'Xandra Leonard', 'MASCULINO', '48996850323', 'O+', '1234561', 78, 2, 79),
(80, '186.402.484-22', '2019-07-11', 'Rhiannon Deleon', 'MASCULINO', '48996850323', 'O+', '1234562', 81, 3, 82),
(83, '186.402.484-23', '2019-07-11', 'Deirdre Jacobs', 'MASCULINO', '48996850323', 'O+', '1234563', 84, 4, 85),
(86, '186.402.484-24', '2019-07-11', 'Julian Goodman', 'MASCULINO', '48996850323', 'O+', '1234564', 87, 5, 88),
(89, '086.402.199-23', '2019-07-11', 'Gage Horn', 'MASCULINO', '48996850323', 'O+', '1234565', 90, 6, 91),
(92, '186.402.484-26', '2019-07-11', 'Zephania Wall', 'MASCULINO', '48996850323', 'O+', '1234566', 93, 7, 94),
(95, '186.402.484-27', '2019-07-11', 'Timothy Pope', 'MASCULINO', '48996850323', 'O+', '1234567', 96, 8, 97),
(98, '186.402.484-28', '2019-07-11', 'Hayes Mullen', 'MASCULINO', '48996850323', 'O+', '1234568', 99, NULL, 100),
(101, '186.402.484-29', '2019-07-11', 'Timon Blankenship', 'MASCULINO', '48996850323', 'O+', '1234569', 102, 10, 103),
(134, '186.402.484-30', '2019-07-11', 'Tucker Church', 'MASCULINO', '48996850323', 'O+', '123460', 135, 1, 136),
(137, '186.402.484-31', '2019-07-11', 'Martena Whitfield', 'MASCULINO', '48996850323', 'O+', '123461', 138, 2, 139),
(140, '186.402.484-32', '2019-07-11', 'Rhiannon Deleon', 'MASCULINO', '48996850323', 'O+', '123462', 141, 3, 142),
(143, '186.402.484-33', '2019-07-11', 'Xenos Walton', 'MASCULINO', '48996850323', 'O+', '123463', 144, 4, 145),
(146, '098.072.199-73', '2019-07-11', 'Xandra Leonard', 'MASCULINO', '48996850323', 'O+', '123464', 147, 5, 148),
(149, '186.402.484-35', '2019-07-11', 'Daniel Dean', 'MASCULINO', '48996850323', 'O+', '123465', 150, 6, 151),
(152, '186.402.484-36', '2019-07-11', 'Daphne Morgan', 'MASCULINO', '48996850323', 'O+', '123466', 153, 7, 154),
(155, '186.402.484-37', '2019-07-11', 'Julian Goodman', 'MASCULINO', '48996850323', 'O+', '123467', 156, 8, 157),
(158, '186.402.484-38', '2019-07-11', 'Uriel Valencia', 'MASCULINO', '48996850323', 'O+', '123468', 159, NULL, 160),
(161, '186.402.484-39', '2019-07-11', 'Karyn Holman', 'MASCULINO', '48996850323', 'O+', '123469', 162, 10, 163);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Especialidade`
--

CREATE TABLE `Especialidade` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `especialidade` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Especialidade`
--

INSERT INTO `Especialidade` (`id`, `descricao`, `especialidade`) VALUES
(1, 'Faz Cirurgia', 'Cirurgia Geral'),
(2, '', 'Obstétrica'),
(3, ' ', 'Oncológica'),
(4, ' ', 'Nefrologia'),
(5, ' ', 'Clínica Médica'),
(6, ' ', 'Dermatologia'),
(7, ' ', 'Endoscopia'),
(8, ' ', 'Infectologia'),
(10, ' ', 'Oftalmologia'),
(11, ' ', 'Ortopedia'),
(12, ' ', 'Traumatologia'),
(13, ' ', 'Psiquiatria');

-- --------------------------------------------------------

--
-- Estrutura da tabela `Exame`
--

CREATE TABLE `Exame` (
  `id` int(11) NOT NULL,
  `descrição` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Exame`
--

INSERT INTO `Exame` (`id`, `descrição`, `nome`) VALUES
(281, '', 'Sangue'),
(282, '', 'Raio X'),
(283, '', 'Tomografia'),
(284, '', 'Ressônancia Magnética'),
(285, '', 'Sangue'),
(286, '', 'Ultra-sonografia'),
(287, '', 'Hemograma'),
(288, '', 'Urina'),
(289, '', 'Fezes'),
(290, '', 'HIV'),
(291, '', 'Sífilis'),
(292, '', 'Glicemia em Jejum');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ExamePaciente`
--

CREATE TABLE `ExamePaciente` (
  `id` int(11) NOT NULL,
  `dataAgendamento` datetime NOT NULL,
  `resultado` varchar(255) DEFAULT NULL,
  `idAtendente` int(11) NOT NULL,
  `idEnfermeiro` int(11) DEFAULT NULL,
  `idExame` int(11) NOT NULL,
  `idMedico` int(11) DEFAULT NULL,
  `idOcupacaoSala` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `ExamePaciente`
--

INSERT INTO `ExamePaciente` (`id`, `dataAgendamento`, `resultado`, `idAtendente`, `idEnfermeiro`, `idExame`, `idMedico`, `idOcupacaoSala`, `idPaciente`) VALUES
(316, '2019-07-11 20:27:53', NULL, 268, NULL, 281, 14, 317, 192),
(320, '2019-07-11 20:28:27', NULL, 268, NULL, 281, 14, 321, 176);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Funcao`
--

CREATE TABLE `Funcao` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Funcao`
--

INSERT INTO `Funcao` (`id`, `nome`) VALUES
(245, 'Aplicação de Vacinas'),
(246, 'Cirurgica'),
(244, 'Consultório'),
(248, 'Teste'),
(247, 'Triagem');

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339),
(339);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Medico`
--

CREATE TABLE `Medico` (
  `id` int(11) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `tipoSanguineo` varchar(255) NOT NULL,
  `crm` varchar(255) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `idEspecialidade` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Medico`
--

INSERT INTO `Medico` (`id`, `cpf`, `dataNascimento`, `nome`, `sexo`, `telefone`, `tipoSanguineo`, `crm`, `idEndereco`, `idEspecialidade`, `idUsuario`) VALUES
(14, '186.402.484-20', '2019-07-11', 'Karyn Holman', 'MASCULINO', '48996850323', 'O+', '1234560', 15, 1, 16),
(17, '186.402.484-21', '2019-07-11', 'Ria Richard', 'MASCULINO', '48996850323', 'O+', '1234561', 18, 2, 19),
(20, '186.402.484-22', '2019-07-11', 'Anthony Shannon', 'MASCULINO', '48996850323', 'O+', '1234562', 21, 3, 22),
(23, '186.402.484-23', '2019-07-11', 'Erin Walker', 'MASCULINO', '48996850323', 'O+', '1234563', 24, 4, 25),
(26, '186.402.484-24', '2019-07-11', 'Jemima Adams', 'MASCULINO', '48996850323', 'O+', '1234564', 27, 5, 28),
(29, '186.402.484-25', '2019-07-11', 'Vincent Guthrie', 'MASCULINO', '48996850323', 'O+', '1234565', 30, 6, 31),
(32, '186.402.484-26', '2019-07-11', 'Gage Horn', 'MASCULINO', '48996850323', 'O+', '1234566', 33, 7, 34),
(35, '186.402.484-27', '2019-07-11', 'Arsenio Mcgee', 'MASCULINO', '48996850323', 'O+', '1234567', 36, 8, 37),
(41, '186.402.484-29', '2019-07-11', 'Vincent Guthrie', 'MASCULINO', '48996850323', 'O+', '1234569', 42, 10, 43),
(44, '186.402.484-20', '2019-07-11', 'Brennan Lopez', 'MASCULINO', '48996850323', 'O+', '123450', 45, 1, 46),
(47, '186.402.484-21', '2019-07-11', 'Macy Snider', 'MASCULINO', '48996850323', 'O+', '123451', 48, 2, 49),
(50, '186.402.484-22', '2019-07-11', 'Rafael Griffin', 'MASCULINO', '48996850323', 'O+', '123452', 51, 3, 52),
(53, '186.402.484-23', '2019-07-11', 'Jonas Aguirre', 'MASCULINO', '48996850323', 'O+', '123453', 54, 4, 55),
(56, '186.402.484-24', '2019-07-11', 'Molly Fox', 'MASCULINO', '48996850323', 'O+', '123454', 57, 5, 58),
(59, '186.402.484-25', '2019-07-11', 'Hayes Mullen', 'MASCULINO', '48996850323', 'O+', '123455', 60, 6, 61),
(62, '186.402.484-26', '2019-07-11', 'Daphne Morgan', 'MASCULINO', '48996850323', 'O+', '123456', 63, 7, 64),
(65, '186.402.484-27', '2019-07-11', 'Palmer Jordan', 'MASCULINO', '48996850323', 'O+', '123457', 66, 8, 67),
(71, '186.402.484-29', '2019-07-11', 'Xanthus Duke', 'MASCULINO', '48996850323', 'O+', '123459', 72, 10, 73),
(327, '086.402.199-23', '2019-07-31', 'henrique lemes', 'MASCULINO', '', 'O+', '12341241213', 328, 1, 329),
(330, '086.402.199-23', '2019-07-26', 'Hnriquewqeq asdasdasd', 'MASCULINO', '', 'O+', '', 331, 1, 332);

-- --------------------------------------------------------

--
-- Estrutura da tabela `OcupacaoSala`
--

CREATE TABLE `OcupacaoSala` (
  `id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `idSala` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `OcupacaoSala`
--

INSERT INTO `OcupacaoSala` (`id`, `data`, `idSala`) VALUES
(272, '2019-07-31 16:00:00', 249),
(274, '2019-07-31 18:00:00', 249),
(276, '2019-07-31 10:00:00', 249),
(278, '2019-07-31 20:00:00', 249),
(280, '2019-07-31 18:00:00', 253),
(303, '2019-07-31 17:00:00', 257),
(305, '2019-07-25 08:00:00', 249),
(317, '2019-07-28 17:00:00', 249),
(319, '2019-07-31 19:00:00', 249),
(321, '2019-07-30 10:00:00', 254);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Paciente`
--

CREATE TABLE `Paciente` (
  `id` int(11) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `tipoSanguineo` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `idEndereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Paciente`
--

INSERT INTO `Paciente` (`id`, `cpf`, `dataNascimento`, `nome`, `sexo`, `telefone`, `tipoSanguineo`, `email`, `idEndereco`) VALUES
(164, '186.200.191-20', '2019-07-11', 'Rhiannon Deleon', 'MASCULINO', NULL, 'O+', 'paciente@email.com0', 165),
(168, '186.200.191-21', '2019-07-11', 'Lara Livingston', 'MASCULINO', NULL, 'O+', 'paciente@email.com1', 169),
(172, '186.200.191-22', '2019-07-11', 'Nevada Rodgers', 'MASCULINO', NULL, 'O+', 'paciente@email.com2', 173),
(176, '186.200.191-23', '2019-07-11', 'Deirdre Jacobs', 'MASCULINO', NULL, 'O+', 'paciente@email.com3', 177),
(180, '186.200.191-24', '2019-07-11', 'Palmer Jordan', 'MASCULINO', NULL, 'O+', 'paciente@email.com4', 181),
(184, '186.200.191-25', '2019-07-11', 'Zephania Wall', 'MASCULINO', NULL, 'O+', 'paciente@email.com5', 185),
(188, '186.200.191-26', '2019-07-11', 'Jerry Porter', 'MASCULINO', NULL, 'O+', 'paciente@email.com6', 189),
(192, '086.402.199-23', '2019-07-11', 'Clinton Gutierrez', 'MASCULINO', NULL, 'O+', 'paciente@email.com', 193),
(196, '186.200.191-28', '2019-07-11', 'Sopoline Heath', 'MASCULINO', NULL, 'O+', 'paciente@email.com8', 197),
(200, '186.200.191-29', '2019-07-11', 'Daphne Morgan', 'MASCULINO', NULL, 'O+', 'paciente@email.com9', 201),
(204, '186.200.191-30', '2019-07-11', 'Prescott Lambert', 'MASCULINO', NULL, 'O+', 'paciente@email.co0', 205),
(208, '186.200.191-31', '2019-07-11', 'Natalie Dodson', 'MASCULINO', NULL, 'O+', 'paciente@email.co1', 209),
(212, '186.200.191-32', '2019-07-11', 'Wanda Lloyd', 'MASCULINO', NULL, 'O+', 'paciente@email.co2', 213),
(216, '186.200.191-33', '2019-07-11', 'Xandra Leonard', 'MASCULINO', NULL, 'O+', 'paciente@email.co3', 217),
(220, '186.200.191-34', '2019-07-11', 'Daphne Morgan', 'MASCULINO', NULL, 'O+', 'paciente@email.co4', 221),
(224, '186.200.191-35', '2019-07-11', 'Rosalyn Melendez', 'MASCULINO', NULL, 'O+', 'paciente@email.co5', 225),
(228, '186.200.191-36', '2019-07-11', 'Shad Melendez', 'MASCULINO', NULL, 'O+', 'paciente@email.co6', 229),
(232, '186.200.191-37', '2019-07-11', 'Dieter Bonner', 'MASCULINO', NULL, 'O+', 'paciente@email.co7', 233),
(236, '186.200.191-38', '2019-07-11', 'Kennedy Bishop', 'MASCULINO', NULL, 'O+', 'paciente@email.co8', 237),
(240, '186.200.191-39', '2019-07-11', 'Chester Zamora', 'MASCULINO', NULL, 'O+', 'paciente@email.co9', 241);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Plantao`
--

CREATE TABLE `Plantao` (
  `id` int(11) NOT NULL,
  `data` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Plantao`
--

INSERT INTO `Plantao` (`id`, `data`) VALUES
(336, '2019-07-12 07:00:00'),
(322, '2019-07-24 07:00:00'),
(325, '2019-07-24 19:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `PlantaoEnfermeiro`
--

CREATE TABLE `PlantaoEnfermeiro` (
  `id` int(11) NOT NULL,
  `idEnfermeiro` int(11) DEFAULT NULL,
  `idPlantao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `PlantaoEnfermeiro`
--

INSERT INTO `PlantaoEnfermeiro` (`id`, `idEnfermeiro`, `idPlantao`) VALUES
(337, 74, 336);

-- --------------------------------------------------------

--
-- Estrutura da tabela `PlantaoMedico`
--

CREATE TABLE `PlantaoMedico` (
  `id` int(11) NOT NULL,
  `idMedico` int(11) NOT NULL,
  `idPlantao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `PlantaoMedico`
--

INSERT INTO `PlantaoMedico` (`id`, `idMedico`, `idPlantao`) VALUES
(323, 14, 322),
(324, 17, 322),
(326, 17, 325),
(338, 14, 336);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Remedio`
--

CREATE TABLE `Remedio` (
  `id` int(11) NOT NULL,
  `decricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `idConsulta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Remedio`
--

INSERT INTO `Remedio` (`id`, `decricao`, `nome`, `idConsulta`) VALUES
(315, '', 'Rivotril', 275);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Sala`
--

CREATE TABLE `Sala` (
  `id` int(11) NOT NULL,
  `descrição` varchar(255) DEFAULT NULL,
  `numero` varchar(255) NOT NULL,
  `idFuncao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Sala`
--

INSERT INTO `Sala` (`id`, `descrição`, `numero`, `idFuncao`) VALUES
(249, NULL, '201', 245),
(250, 'faz cirurgia', '202', 246),
(251, NULL, '203', 247),
(252, NULL, '204', 244),
(253, NULL, '205', 247),
(254, NULL, '206', 246),
(255, NULL, '207', 245),
(256, NULL, '208', 244),
(257, NULL, '209', 247),
(258, NULL, '210', 245);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Telefone`
--

CREATE TABLE `Telefone` (
  `id` int(11) NOT NULL,
  `isEmergencia` bit(1) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero` varchar(255) NOT NULL,
  `parentesco` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `idPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Telefone`
--

INSERT INTO `Telefone` (`id`, `isEmergencia`, `nome`, `numero`, `parentesco`, `tipo`, `idPaciente`) VALUES
(166, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 164),
(167, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 164),
(170, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 168),
(171, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 168),
(174, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 172),
(175, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 172),
(178, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 176),
(179, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 176),
(182, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 180),
(183, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 180),
(186, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 184),
(187, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 184),
(190, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 188),
(191, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 188),
(194, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 192),
(195, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 192),
(198, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 196),
(199, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 196),
(202, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 200),
(203, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 200),
(206, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 204),
(207, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 204),
(210, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 208),
(211, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 208),
(214, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 212),
(215, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 212),
(218, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 216),
(219, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 216),
(222, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 220),
(223, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 220),
(226, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 224),
(227, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 224),
(230, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 228),
(231, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 228),
(234, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 232),
(235, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 232),
(238, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 236),
(239, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 236),
(242, b'1', 'João', '(48)996850323', 'Irmão', 'Celular', 240),
(243, b'1', 'Henrique', '(48)996850323', 'Pai', 'Celular', 240);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Usuario`
--

CREATE TABLE `Usuario` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Usuario`
--

INSERT INTO `Usuario` (`id`, `login`, `senha`) VALUES
(16, 'medico0', '123'),
(19, 'medico1', '123'),
(22, 'medico2', '123'),
(25, 'medico3', '123'),
(28, 'medico4', '123'),
(31, 'medico5', '123'),
(34, 'medico6', '123'),
(37, 'medico7', '123'),
(43, 'medico9', '123'),
(46, 'medicoo0', '123'),
(49, 'medicoo1', '123'),
(52, 'medicoo2', '123'),
(55, 'medicoo3', '123'),
(58, 'medicoo4', '123'),
(61, 'medicoo5', '123'),
(64, 'medicoo6', '123'),
(67, 'medicoo7', '123'),
(73, 'medicoo9', '123'),
(76, 'enfermeiro0', '123'),
(79, 'enfermeiro1', '123'),
(82, 'enfermeiro2', '123'),
(85, 'enfermeiro3', '123'),
(88, 'enfermeiro4', '123'),
(91, 'enfermeiro5@sdasd.com', '123'),
(94, 'enfermeiro6', '123'),
(97, 'enfermeiro7', '123'),
(100, 'enfermeiro8', '123'),
(103, 'enfermeiro9', '123'),
(136, 'enfermeiroo0', '123'),
(139, 'enfermeiroo1', '123'),
(142, 'enfermeiroo2', '123'),
(145, 'enfermeiroo3', '123'),
(148, 'enfermeiroo4@email.com', '123'),
(151, 'enfermeiroo5', '123'),
(154, 'enfermeiroo6', '123'),
(157, 'enfermeiroo7', '123'),
(160, 'enfermeiroo8', '123'),
(163, 'enfermeiroo9', '123'),
(270, 'atendente', '123'),
(329, 'email@email.com', '123'),
(332, 'email@dasdjaklj.com', '123'),
(335, 'jasdbjas@gmail.com', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `Vacina`
--

CREATE TABLE `Vacina` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Vacina`
--

INSERT INTO `Vacina` (`id`, `nome`, `observacao`) VALUES
(259, 'Tetano', ''),
(260, 'Difteria', ''),
(261, 'Triplice-viral', ''),
(262, 'Hepatite-B', ''),
(263, 'Pneumonia', ''),
(264, 'Febre Amarela', ''),
(265, 'Gripe', ''),
(266, 'HPV', ''),
(267, 'Herpes Zóster', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `VacinaAplicada`
--

CREATE TABLE `VacinaAplicada` (
  `id` int(11) NOT NULL,
  `aplicada` bit(1) DEFAULT NULL,
  `dataAgendamento` datetime DEFAULT NULL,
  `idAtendente` int(11) DEFAULT NULL,
  `idEnfermeiro` int(11) DEFAULT NULL,
  `idOcupacaoSala` int(11) DEFAULT NULL,
  `idPaciente` int(11) NOT NULL,
  `idVacina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `VacinaAplicada`
--

INSERT INTO `VacinaAplicada` (`id`, `aplicada`, `dataAgendamento`, `idAtendente`, `idEnfermeiro`, `idOcupacaoSala`, `idPaciente`, `idVacina`) VALUES
(318, b'1', '2019-07-11 20:28:10', 268, NULL, 319, 184, 259);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Atendente`
--
ALTER TABLE `Atendente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK75t0rl9fc37ykugwnfj75fbne` (`idEndereco`),
  ADD KEY `FK29yq6at6c1q8qdw1muyj7xs7g` (`idUsuario`);

--
-- Indexes for table `Consulta`
--
ALTER TABLE `Consulta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbarambpj17m9nvmx8fyc7q832` (`idAtendente`),
  ADD KEY `FKl3jcxrttyj7aopqlg3if3tl8w` (`idEspecialidade`),
  ADD KEY `FKp3ox3un75g16p64nygsbsuwqc` (`idMedico`),
  ADD KEY `FKn09s80jqoxkpd7wp2khfrtp2y` (`idOcupacaoSala`),
  ADD KEY `FK5phcxkmkds95ec1kmeuhcv0wd` (`idPaciente`);

--
-- Indexes for table `Doenca`
--
ALTER TABLE `Doenca`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `doenca_paciente`
--
ALTER TABLE `doenca_paciente`
  ADD KEY `FKpwb1cpnbj877yedubae7cnuvx` (`idDoenca`),
  ADD KEY `FKk6vs7td0n6g4is7v6kh5w5l4k` (`idPaciente`);

--
-- Indexes for table `Endereco`
--
ALTER TABLE `Endereco`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Enfermeiro`
--
ALTER TABLE `Enfermeiro`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_thd06qa6algab84iw57422ucm` (`corenCofen`),
  ADD KEY `FK3cqas88vq4d27tbtevthfbiow` (`idEndereco`),
  ADD KEY `FK7w0tp5mmrumd0etg3c3enhjxl` (`idEspecialidade`),
  ADD KEY `FK6gvpapi1pfwklcxsqq9bauggi` (`idUsuario`);

--
-- Indexes for table `Especialidade`
--
ALTER TABLE `Especialidade`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_bt0dwcg1ypno8ek55n0cnxbax` (`especialidade`);

--
-- Indexes for table `Exame`
--
ALTER TABLE `Exame`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ExamePaciente`
--
ALTER TABLE `ExamePaciente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjuqoj662dt3qgw3jas80j33mh` (`idAtendente`),
  ADD KEY `FK4gvyb3jda2qiafo1tckc2v1mo` (`idEnfermeiro`),
  ADD KEY `FK846y3sbc6tlmeoyds6xuulyvb` (`idExame`),
  ADD KEY `FKbre283kxbf4fsaar7hut21ka1` (`idMedico`),
  ADD KEY `FK2k3biebagfw1n4qkvgxpk5pgc` (`idOcupacaoSala`),
  ADD KEY `FKcbrk2hw553b42d2nl9k4au8np` (`idPaciente`);

--
-- Indexes for table `Funcao`
--
ALTER TABLE `Funcao`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_5tuseq32wi3mrtgtlns0pvu5v` (`nome`);

--
-- Indexes for table `Medico`
--
ALTER TABLE `Medico`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_4mxaf7akak8hrpgyr1u46yw1k` (`crm`),
  ADD KEY `FKmi92l9lmrkxbj3uq33u76nlf` (`idEndereco`),
  ADD KEY `FKdmclvr2kjnm3jmdlidvshffwt` (`idEspecialidade`),
  ADD KEY `FKmlha7h0vhim3j0hh44c470spj` (`idUsuario`);

--
-- Indexes for table `OcupacaoSala`
--
ALTER TABLE `OcupacaoSala`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK43l5o9a8yb3s0ptbdeq1emrqy` (`idSala`);

--
-- Indexes for table `Paciente`
--
ALTER TABLE `Paciente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhdh2sei2b5fcyt9vqtysv0pfg` (`idEndereco`);

--
-- Indexes for table `Plantao`
--
ALTER TABLE `Plantao`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_7leiiuq59wy4gc09srj73fan0` (`data`);

--
-- Indexes for table `PlantaoEnfermeiro`
--
ALTER TABLE `PlantaoEnfermeiro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbv24u2riac5uss4l6wp9u0eft` (`idEnfermeiro`),
  ADD KEY `FK2333uie4ev8hdc0foscgtinct` (`idPlantao`);

--
-- Indexes for table `PlantaoMedico`
--
ALTER TABLE `PlantaoMedico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK16x4ryrxr7yjoxg0562rkxu7b` (`idMedico`),
  ADD KEY `FKr993trabysm8jh9gfoficg9f` (`idPlantao`);

--
-- Indexes for table `Remedio`
--
ALTER TABLE `Remedio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrxl26a8e285l9u9neck24nrip` (`idConsulta`);

--
-- Indexes for table `Sala`
--
ALTER TABLE `Sala`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_bp7r4y0k20xx6rlibfra3ncce` (`numero`),
  ADD KEY `FK3w508p4swrohr7067gda3yoy9` (`idFuncao`);

--
-- Indexes for table `Telefone`
--
ALTER TABLE `Telefone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2xlw12tquis9l6elu7111kif9` (`idPaciente`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_g1orfqvgih1w8s3vyg15fq2b8` (`login`);

--
-- Indexes for table `Vacina`
--
ALTER TABLE `Vacina`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `VacinaAplicada`
--
ALTER TABLE `VacinaAplicada`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5utwfk2xsjyse1ksdotgy84uw` (`idAtendente`),
  ADD KEY `FK45ouu3oejbhhbx331372235s6` (`idEnfermeiro`),
  ADD KEY `FK6djmka66ynyhxe0erlle78eea` (`idOcupacaoSala`),
  ADD KEY `FK1mwde18c37p3q9f2lesima6hn` (`idPaciente`),
  ADD KEY `FKimj5s1c5fs5tgd4jc2alt3sre` (`idVacina`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `Atendente`
--
ALTER TABLE `Atendente`
  ADD CONSTRAINT `FK29yq6at6c1q8qdw1muyj7xs7g` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`id`),
  ADD CONSTRAINT `FK75t0rl9fc37ykugwnfj75fbne` FOREIGN KEY (`idEndereco`) REFERENCES `Endereco` (`id`);

--
-- Limitadores para a tabela `Consulta`
--
ALTER TABLE `Consulta`
  ADD CONSTRAINT `FK5phcxkmkds95ec1kmeuhcv0wd` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`id`),
  ADD CONSTRAINT `FKbarambpj17m9nvmx8fyc7q832` FOREIGN KEY (`idAtendente`) REFERENCES `Atendente` (`id`),
  ADD CONSTRAINT `FKl3jcxrttyj7aopqlg3if3tl8w` FOREIGN KEY (`idEspecialidade`) REFERENCES `Especialidade` (`id`),
  ADD CONSTRAINT `FKn09s80jqoxkpd7wp2khfrtp2y` FOREIGN KEY (`idOcupacaoSala`) REFERENCES `OcupacaoSala` (`id`),
  ADD CONSTRAINT `FKp3ox3un75g16p64nygsbsuwqc` FOREIGN KEY (`idMedico`) REFERENCES `Medico` (`id`);

--
-- Limitadores para a tabela `doenca_paciente`
--
ALTER TABLE `doenca_paciente`
  ADD CONSTRAINT `FKk6vs7td0n6g4is7v6kh5w5l4k` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`id`),
  ADD CONSTRAINT `FKpwb1cpnbj877yedubae7cnuvx` FOREIGN KEY (`idDoenca`) REFERENCES `Doenca` (`id`);

--
-- Limitadores para a tabela `Enfermeiro`
--
ALTER TABLE `Enfermeiro`
  ADD CONSTRAINT `FK3cqas88vq4d27tbtevthfbiow` FOREIGN KEY (`idEndereco`) REFERENCES `Endereco` (`id`),
  ADD CONSTRAINT `FK6gvpapi1pfwklcxsqq9bauggi` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`id`),
  ADD CONSTRAINT `FK7w0tp5mmrumd0etg3c3enhjxl` FOREIGN KEY (`idEspecialidade`) REFERENCES `Especialidade` (`id`);

--
-- Limitadores para a tabela `ExamePaciente`
--
ALTER TABLE `ExamePaciente`
  ADD CONSTRAINT `FK2k3biebagfw1n4qkvgxpk5pgc` FOREIGN KEY (`idOcupacaoSala`) REFERENCES `OcupacaoSala` (`id`),
  ADD CONSTRAINT `FK4gvyb3jda2qiafo1tckc2v1mo` FOREIGN KEY (`idEnfermeiro`) REFERENCES `Enfermeiro` (`id`),
  ADD CONSTRAINT `FK846y3sbc6tlmeoyds6xuulyvb` FOREIGN KEY (`idExame`) REFERENCES `Exame` (`id`),
  ADD CONSTRAINT `FKbre283kxbf4fsaar7hut21ka1` FOREIGN KEY (`idMedico`) REFERENCES `Medico` (`id`),
  ADD CONSTRAINT `FKcbrk2hw553b42d2nl9k4au8np` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`id`),
  ADD CONSTRAINT `FKjuqoj662dt3qgw3jas80j33mh` FOREIGN KEY (`idAtendente`) REFERENCES `Atendente` (`id`);

--
-- Limitadores para a tabela `Medico`
--
ALTER TABLE `Medico`
  ADD CONSTRAINT `FKdmclvr2kjnm3jmdlidvshffwt` FOREIGN KEY (`idEspecialidade`) REFERENCES `Especialidade` (`id`),
  ADD CONSTRAINT `FKmi92l9lmrkxbj3uq33u76nlf` FOREIGN KEY (`idEndereco`) REFERENCES `Endereco` (`id`),
  ADD CONSTRAINT `FKmlha7h0vhim3j0hh44c470spj` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`id`);

--
-- Limitadores para a tabela `OcupacaoSala`
--
ALTER TABLE `OcupacaoSala`
  ADD CONSTRAINT `FK43l5o9a8yb3s0ptbdeq1emrqy` FOREIGN KEY (`idSala`) REFERENCES `Sala` (`id`);

--
-- Limitadores para a tabela `Paciente`
--
ALTER TABLE `Paciente`
  ADD CONSTRAINT `FKhdh2sei2b5fcyt9vqtysv0pfg` FOREIGN KEY (`idEndereco`) REFERENCES `Endereco` (`id`);

--
-- Limitadores para a tabela `PlantaoEnfermeiro`
--
ALTER TABLE `PlantaoEnfermeiro`
  ADD CONSTRAINT `FK2333uie4ev8hdc0foscgtinct` FOREIGN KEY (`idPlantao`) REFERENCES `Plantao` (`id`),
  ADD CONSTRAINT `FKbv24u2riac5uss4l6wp9u0eft` FOREIGN KEY (`idEnfermeiro`) REFERENCES `Enfermeiro` (`id`);

--
-- Limitadores para a tabela `PlantaoMedico`
--
ALTER TABLE `PlantaoMedico`
  ADD CONSTRAINT `FK16x4ryrxr7yjoxg0562rkxu7b` FOREIGN KEY (`idMedico`) REFERENCES `Medico` (`id`),
  ADD CONSTRAINT `FKr993trabysm8jh9gfoficg9f` FOREIGN KEY (`idPlantao`) REFERENCES `Plantao` (`id`);

--
-- Limitadores para a tabela `Remedio`
--
ALTER TABLE `Remedio`
  ADD CONSTRAINT `FKrxl26a8e285l9u9neck24nrip` FOREIGN KEY (`idConsulta`) REFERENCES `Consulta` (`id`);

--
-- Limitadores para a tabela `Sala`
--
ALTER TABLE `Sala`
  ADD CONSTRAINT `FK3w508p4swrohr7067gda3yoy9` FOREIGN KEY (`idFuncao`) REFERENCES `Funcao` (`id`);

--
-- Limitadores para a tabela `Telefone`
--
ALTER TABLE `Telefone`
  ADD CONSTRAINT `FK2xlw12tquis9l6elu7111kif9` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`id`);

--
-- Limitadores para a tabela `VacinaAplicada`
--
ALTER TABLE `VacinaAplicada`
  ADD CONSTRAINT `FK1mwde18c37p3q9f2lesima6hn` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`id`),
  ADD CONSTRAINT `FK45ouu3oejbhhbx331372235s6` FOREIGN KEY (`idEnfermeiro`) REFERENCES `Enfermeiro` (`id`),
  ADD CONSTRAINT `FK5utwfk2xsjyse1ksdotgy84uw` FOREIGN KEY (`idAtendente`) REFERENCES `Atendente` (`id`),
  ADD CONSTRAINT `FK6djmka66ynyhxe0erlle78eea` FOREIGN KEY (`idOcupacaoSala`) REFERENCES `OcupacaoSala` (`id`),
  ADD CONSTRAINT `FKimj5s1c5fs5tgd4jc2alt3sre` FOREIGN KEY (`idVacina`) REFERENCES `Vacina` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
