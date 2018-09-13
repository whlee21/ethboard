var ethBoard = artifacts.require("ethBoard");

contract('ethboardTest', function(accounts) {
  it('should deploy the ethBoard the address', function(done){
    ethBoard.deployed().then(async function(instance) {
        const ethBoard = await instance;
        console.log(ethBoard);
        assert(ethBoard, 'ethBoard address couldn\'t be stored');
        done();
   });
  });

  it('get numbaer of posts', function(done){
    ethBoard.deployed().then(async function(instance) {
        assert(ethBoard, 'ethBoard address couldn\'t be stored');
        done();
   });
  });

  it('add post', function(done){
    ethBoard.deployed().then(async function(instance) {
        const data = await instance.addPost('test1', 'test contest', 'testUser');
        done();
   });
});

it('add post2', function(done){
  ethBoard.deployed().then(async function(instance) {
      const data = await instance.addPost('test2', 'test contest2', 'testUser2');
      done();
 });
});

it('get numbaer of posts', function(done){
  ethBoard.deployed().then(async function(instance) {
      const ethBoard = await instance.getNumOfPosts.call();
      console.log(ethBoard);
      done();
 });
});
it('get post', function(done){
  ethBoard.deployed().then(async function(instance) {
      const post = await instance.getPost(0);
      console.log("ID: " ,post[0].toNumber());
      console.log("Title: " ,post[1]);
      console.log("Content: " ,post[2]);
      console.log("Owner name " ,post[3]);
      console.log("Owner account " ,post[4]);
      done();
 });
});
it('get post', function(done){
  ethBoard.deployed().then(async function(instance) {
      const post = await instance.getPost(1);
      console.log("ID: " ,post[0].toNumber());
      console.log("Title: " ,post[1]);
      console.log("Content: " ,post[2]);
      console.log("Owner name " ,post[3]);
      console.log("Owner account " ,post[4]);
      done();
 });
});
});
