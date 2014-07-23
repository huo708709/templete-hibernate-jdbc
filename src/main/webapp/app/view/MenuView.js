Ext.define('Westar.view.MenuView', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.menuView',
    rootVisible: false,
    autoHeight: true,
    store: 'MenuStore',
    width: '100%',
    height: '100%',
    initComponent: function() {
    	this.callParent(arguments);
    }
});