-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Fev-2021 às 15:10
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `imovel`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `imoveis`
--

CREATE TABLE `imoveis` (
  `idImovel` int(11) NOT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `nbairro` varchar(11) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `cep` varchar(50) DEFAULT NULL,
  `locavenda` tinyint(4) DEFAULT NULL,
  `valor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `imoveis`
--

INSERT INTO `imoveis` (`idImovel`, `endereco`, `nbairro`, `cidade`, `cep`, `locavenda`, `valor`) VALUES
(6, 'djdjdj', 'djjdj', 'sjd', '44', 1, '4'),
(9, 'ss', 'j', 'fr', 'kkjwed', 0, '55555'),
(15, 'bbb', 'j', 'fr', 'kkjwed', 1, '55555'),
(16, 'rua abril', '7', 'fw kkkk', '2615', 0, '25555'),
(17, 'rua iffar', '3\'', 'frederico', '984120', 0, '5000'),
(18, 'rua iffar', '3888', 'frederico', '984120855', 0, '500055');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `imoveis`
--
ALTER TABLE `imoveis`
  ADD PRIMARY KEY (`idImovel`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `imoveis`
--
ALTER TABLE `imoveis`
  MODIFY `idImovel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
