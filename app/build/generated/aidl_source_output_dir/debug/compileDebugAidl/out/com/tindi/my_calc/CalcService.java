/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.tindi.my_calc;
// Declare any non-default types here with import statements

public interface CalcService extends android.os.IInterface
{
  /** Default implementation for CalcService. */
  public static class Default implements com.tindi.my_calc.CalcService
  {
    /**
         * Calculator functions..
    
         */
    @Override public double add(double firstValue, double secondValue) throws android.os.RemoteException
    {
      return 0.0d;
    }
    @Override public double subtract(double firstValue, double secondValue) throws android.os.RemoteException
    {
      return 0.0d;
    }
    @Override public double multiply(double firstValue, double secondValue) throws android.os.RemoteException
    {
      return 0.0d;
    }
    @Override public double divide(double firstValue, double secondValue) throws android.os.RemoteException
    {
      return 0.0d;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.tindi.my_calc.CalcService
  {
    private static final java.lang.String DESCRIPTOR = "com.tindi.my_calc.CalcService";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.tindi.my_calc.CalcService interface,
     * generating a proxy if needed.
     */
    public static com.tindi.my_calc.CalcService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.tindi.my_calc.CalcService))) {
        return ((com.tindi.my_calc.CalcService)iin);
      }
      return new com.tindi.my_calc.CalcService.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_add:
        {
          data.enforceInterface(descriptor);
          double _arg0;
          _arg0 = data.readDouble();
          double _arg1;
          _arg1 = data.readDouble();
          double _result = this.add(_arg0, _arg1);
          reply.writeNoException();
          reply.writeDouble(_result);
          return true;
        }
        case TRANSACTION_subtract:
        {
          data.enforceInterface(descriptor);
          double _arg0;
          _arg0 = data.readDouble();
          double _arg1;
          _arg1 = data.readDouble();
          double _result = this.subtract(_arg0, _arg1);
          reply.writeNoException();
          reply.writeDouble(_result);
          return true;
        }
        case TRANSACTION_multiply:
        {
          data.enforceInterface(descriptor);
          double _arg0;
          _arg0 = data.readDouble();
          double _arg1;
          _arg1 = data.readDouble();
          double _result = this.multiply(_arg0, _arg1);
          reply.writeNoException();
          reply.writeDouble(_result);
          return true;
        }
        case TRANSACTION_divide:
        {
          data.enforceInterface(descriptor);
          double _arg0;
          _arg0 = data.readDouble();
          double _arg1;
          _arg1 = data.readDouble();
          double _result = this.divide(_arg0, _arg1);
          reply.writeNoException();
          reply.writeDouble(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.tindi.my_calc.CalcService
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
           * Calculator functions..
      
           */
      @Override public double add(double firstValue, double secondValue) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        double _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeDouble(firstValue);
          _data.writeDouble(secondValue);
          boolean _status = mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().add(firstValue, secondValue);
          }
          _reply.readException();
          _result = _reply.readDouble();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public double subtract(double firstValue, double secondValue) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        double _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeDouble(firstValue);
          _data.writeDouble(secondValue);
          boolean _status = mRemote.transact(Stub.TRANSACTION_subtract, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().subtract(firstValue, secondValue);
          }
          _reply.readException();
          _result = _reply.readDouble();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public double multiply(double firstValue, double secondValue) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        double _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeDouble(firstValue);
          _data.writeDouble(secondValue);
          boolean _status = mRemote.transact(Stub.TRANSACTION_multiply, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().multiply(firstValue, secondValue);
          }
          _reply.readException();
          _result = _reply.readDouble();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public double divide(double firstValue, double secondValue) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        double _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeDouble(firstValue);
          _data.writeDouble(secondValue);
          boolean _status = mRemote.transact(Stub.TRANSACTION_divide, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().divide(firstValue, secondValue);
          }
          _reply.readException();
          _result = _reply.readDouble();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.tindi.my_calc.CalcService sDefaultImpl;
    }
    static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_subtract = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_multiply = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_divide = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    public static boolean setDefaultImpl(com.tindi.my_calc.CalcService impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.tindi.my_calc.CalcService getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
       * Calculator functions..
  
       */
  public double add(double firstValue, double secondValue) throws android.os.RemoteException;
  public double subtract(double firstValue, double secondValue) throws android.os.RemoteException;
  public double multiply(double firstValue, double secondValue) throws android.os.RemoteException;
  public double divide(double firstValue, double secondValue) throws android.os.RemoteException;
}
