var ethboard = artifacts.require("ethboard")

module.exports = function(deployer) {
  deployer.deploy(ethboard)
}