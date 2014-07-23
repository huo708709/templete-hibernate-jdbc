Ext.define('Westar.controller.MenuController', {
    extend: 'Ext.app.Controller',
    views: ['MenuView'],
    stores: ['MenuStore'],
    models: [],

    init: function() {
    	var tree = null;
        this.control({
        	'menuView': {
        		render: function(t, eOpts){
                    tree = t;
                },
                beforeitemexpand: function(node, eOpts ) {
                	Ext.apply(tree.getStore().proxy.extraParams,{
                		pid: node.data.id
                	});
                },
                itemclick: this.menuClick
        	}
        });
    },
    menuClick: function(node, record, item, index, e, eOpts) {
    	
    }
});
